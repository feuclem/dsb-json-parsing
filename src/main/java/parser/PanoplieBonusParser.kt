package parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Bonus
import domain.Equipement
import domain.FromTo
import domain.PanoplieBonus
import domain.Statistic
import org.apache.commons.io.FileUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.util.ArrayList
import java.util.Arrays
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import java.util.function.Consumer

class PanoplieBonusParser {

    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
    }

    private val equipementsDir = javaClass.getResource("/equipements.json").path

    fun write() {
        val equipementsJson: List<Equipement> = mapper.readValue(equipementsDir)
        val setIdList: List<Int> = equipementsJson.map { it.setId }
        setIdList.forEach {
            if (it != 0) {
                writeInFile(it)
            }
        }
    }

    private fun writeInFile(id: Int) {
        val panoplieBonus = PanoplieBonus()
        val pathFile = File(javaClass.getResource("/panoplies/$id.json").path)
        if (pathFile.length() == 0L) {
            println("PARSER LA PANOPLIE ID : $id")
            val delayed: Executor = CompletableFuture.delayedExecutor(5L, TimeUnit.SECONDS)
            CompletableFuture.supplyAsync({ "izi" }, delayed)
                .thenAccept {
                    val doc: Document = Jsoup.connect("https://www.dofus.com/fr/mmorpg/encyclopedie/panoplies/$id").get()
                    val setBonusList = doc.select("body .ak-encyclo-detail-right .set-bonus-list")
                    val bonusList: MutableList<Bonus> = mutableListOf()
                    var numberOfItemInBonus = 2
                    for (setBonus in setBonusList) {
                        val statisticList: MutableList<Statistic> = ArrayList<Statistic>(emptyList())
                        val bonusHmtl: List<String> = setBonus.select(".ak-title").html().split("\n")
                        bonusHmtl.forEach(Consumer { valueInHtml: String ->
                            if (valueInHtml.contains("Dommages Critiques")) {
                                val stat = Statistic()
                                stat.dommagesCritiques = FromTo(
                                    valueInHtml.split(" ").toTypedArray()[0],
                                    valueInHtml.split(" ").toTypedArray()[0]
                                )
                                statisticList.add(stat)
                            } else if (valueInHtml.contains("Puissance")) {
                                val stat = Statistic()
                                stat.puissance = FromTo(
                                    valueInHtml.split(" ").toTypedArray()[0],
                                    valueInHtml.split(" ").toTypedArray()[0]
                                )
                                statisticList.add(stat)
                            } else if (valueInHtml.contains("PA")) {
                                val stat = Statistic()
                                stat.pa = FromTo(
                                    valueInHtml.split(" ").toTypedArray()[0],
                                    valueInHtml.split(" ").toTypedArray()[0]
                                )
                                statisticList.add(stat)
                            } else {
                                val stat = Statistic()
                                stat.vitalite = FromTo(
                                    valueInHtml.split(" ").toTypedArray()[0],
                                    valueInHtml.split(" ").toTypedArray()[0]
                                )
                                statisticList.add(stat)
                            }
                        })
                        val bonus = Bonus()
                        bonus.number = numberOfItemInBonus
                        bonus.stats = statisticList
                        bonusList.add(bonus)
                        panoplieBonus.id = id
                        panoplieBonus.bonus = bonusList
                        numberOfItemInBonus++
                    }
                    mapper.writeValue(File(javaClass.getResource("/panoplies/$id.json").path), panoplieBonus)
                }
                .join()
        } else {
            println("LA PANOPLIE ID : $id EST DEJA PARSEE")
        }
    }

    // Pour générer tous les fichiers
    fun createAllJsonFile(setIdList: List<Int>) {
        FileUtils.cleanDirectory(File(javaClass.getResource("/panoplies").path))
        setIdList.forEach { id: Int ->
            File(javaClass.getResource("/panoplies").path, "$id.json").createNewFile()
        }
    }
}