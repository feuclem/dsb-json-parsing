package parser

import Deserializer.readFile
import Serializer.writeObjectInFile
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
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import java.util.function.Consumer

class PanoplieBonusParser {

    private val equipementsDir = javaClass.getResource("/equipements.json").path

    fun write() {
        val equipementsJson: List<Equipement> = readFile(equipementsDir)
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
            CompletableFuture.supplyAsync({}, delayed)
                .thenAccept {
                    val doc: Document =
                        Jsoup.connect("https://www.dofus.com/fr/mmorpg/encyclopedie/panoplies/$id").get()
                    val setBonusList = doc.select("body .ak-encyclo-detail-right .set-bonus-list")
                    println("A RECUPERER " + setBonusList.size + " BONUS DE PANOPLIE")
                    val bonusList: MutableList<Bonus> = mutableListOf()
                    var numberOfItemInBonus = 2
                    setBonusList.forEach { setBonus ->
                        val statisticList: MutableList<Statistic> = ArrayList<Statistic>(emptyList())
                        val bonusHmtl: List<String> = setBonus.select(".ak-title").html().split("\n")
                        bonusHmtl.forEach(Consumer { valueInHtml: String ->
                            when {
                                valueInHtml.contains("PA") -> {
                                    val stat = Statistic()
                                    stat.pa = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("PM") -> {
                                    val stat = Statistic()
                                    stat.pm = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Portée") -> {
                                    val stat = Statistic()
                                    stat.po = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }

                                valueInHtml.contains("Sagesse") -> {
                                    val stat = Statistic()
                                    stat.sagesse = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Soins") -> {
                                    val stat = Statistic()
                                    stat.soins = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Critique") -> {
                                    val stat = Statistic()
                                    stat.critique = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Puissance") -> {
                                    val stat = Statistic()
                                    stat.puissance = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Force") -> {
                                    val stat = Statistic()
                                    stat.force = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Intelligence") -> {
                                    val stat = Statistic()
                                    stat.intelligence = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Chance") -> {
                                    val stat = Statistic()
                                    stat.chance = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Agilité") -> {
                                    val stat = Statistic()
                                    stat.agilite = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Initiative") -> {
                                    val stat = Statistic()
                                    stat.initiative = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages Neutre") -> {
                                    val stat = Statistic()
                                    stat.dommagesNeutre = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages Feu") -> {
                                    val stat = Statistic()
                                    stat.dommagesFeu = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages Eau") -> {
                                    val stat = Statistic()
                                    stat.dommagesEau = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages Air") -> {
                                    val stat = Statistic()
                                    stat.dommagesAir = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages") -> {
                                    val stat = Statistic()
                                    stat.dommages = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages Critiques") -> {
                                    val stat = Statistic()
                                    stat.dommagesCritiques = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Dommages Poussée") -> {
                                    val stat = Statistic()
                                    stat.dommagesPoussee = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance Neutre") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceNeutre = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance Terre") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceTerre = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance Feu") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceFeu = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance Eau") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceEau = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance Air") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceAir = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Critiques") -> {
                                    val stat = Statistic()
                                    stat.resistanceCritiques = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Poussée") -> {
                                    val stat = Statistic()
                                    stat.resistancePoussee = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Tacle") -> {
                                    val stat = Statistic()
                                    stat.tacle = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Fuite") -> {
                                    val stat = Statistic()
                                    stat.fuite = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Esquive PA") -> {
                                    val stat = Statistic()
                                    stat.esquivePa = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Esquive PM") -> {
                                    val stat = Statistic()
                                    stat.esquivePm = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Retrait PA") -> {
                                    val stat = Statistic()
                                    stat.retraitPa = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Retrait PM") -> {
                                    val stat = Statistic()
                                    stat.retraitPm = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Neutre") -> {
                                    val stat = Statistic()
                                    stat.resistanceFixeNeutre = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Terre") -> {
                                    val stat = Statistic()
                                    stat.resistanceFixeTerre = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Feu") -> {
                                    val stat = Statistic()
                                    stat.resistanceFixeFeu = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Eau") -> {
                                    val stat = Statistic()
                                    stat.resistanceFixeEau = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Résistance Air") -> {
                                    val stat = Statistic()
                                    stat.resistanceFixeAir = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Prospection") -> {
                                    val stat = Statistic()
                                    stat.prospection = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Invocations") -> {
                                    val stat = Statistic()
                                    stat.invocations = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance distance") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceDistance = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Résistance mêlée") -> {
                                    val stat = Statistic()
                                    stat.pourcentResistanceMelee = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Dommages mêlée") -> {
                                    val stat = Statistic()
                                    stat.pourcentDommagesMelee = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Dommages distance") -> {
                                    val stat = Statistic()
                                    stat.pourcentDommagesDistance = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("% Dommages aux sorts") -> {
                                    val stat = Statistic()
                                    stat.dommagesSorts = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                valueInHtml.contains("Pods") -> {
                                    val stat = Statistic()
                                    stat.pods = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
                                else -> {
                                    val stat = Statistic()
                                    stat.vitalite = FromTo(
                                        valueInHtml.split(" ").toTypedArray()[0],
                                        valueInHtml.split(" ").toTypedArray()[0]
                                    )
                                    statisticList.add(stat)
                                }
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
                    writeObjectInFile(javaClass.getResource("/panoplies/$id.json").path, panoplieBonus)
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