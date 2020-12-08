package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Bonus
import domain.FromTo
import domain.PanoplieBonus
import domain.Statistic
import domain.json.EquipementJson
import org.apache.commons.io.FileUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import java.io.File
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit
import java.util.function.Consumer

object PanoplieBonusParser {

    fun write(equipementsPath: String, isNeededToGenerateAllFiles: Boolean): List<Boolean> {
        val equipementsJson = jacksonObjectMapper().readValue<List<EquipementJson>>(File(equipementsPath))
        val setIdList: List<Int> = equipementsJson.map { it.setId }.distinct()
        if (isNeededToGenerateAllFiles) createAllJsonFile(setIdList)
        return setIdList.mapNotNull {
            if (it != 0) {
                writeInFile(it)
            } else {
                null
            }
        }
    }

    private fun writeInFile(id: Int): Boolean {
        val panoplieBonus = PanoplieBonus()
        val pathFile = File(javaClass.getResource("/panoplies/$id.json").path)
        return if (pathFile.length() == 0L) {
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
                        val statisticList: MutableList<Statistic> = mutableListOf()
                        val bonusHmtl: List<String> = setBonus.select(".ak-title").html().split("\n")
                        bonusHmtl.forEach(Consumer { valueInHtml: String ->
                            when {
                                valueInHtml.contains("PA") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pa",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("PM") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pm",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Portée") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "po",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }

                                valueInHtml.contains("Sagesse") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "sagesse",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Soins") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "soins",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Critique") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "critique",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Puissance") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "puissance",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Force") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "force",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Intelligence") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "intelligence",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Chance") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "chance",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Agilité") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "agilite",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Initiative") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "initiative",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Dommages Neutre") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesNeutre",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Dommages Feu") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesFeu",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Dommages Eau") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesEau",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Dommages Air") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesAir",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.equals("Dommages") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommages",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Dommages Critiques") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesCritiques",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Dommages Poussée") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesPoussee",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance Neutre") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceNeutre",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance Terre") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceTerre",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance Feu") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceFeu",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance Eau") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceEau",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance Air") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceAir",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Critiques") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistanceCritiques",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Poussée") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistancePoussee",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Tacle") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "tacle",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Fuite") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "fuite",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Esquive PA") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "esquivePa",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Esquive PM") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "esquivePm",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Retrait PA") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "retraitPa",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Retrait PM") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "retraitPm",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Neutre") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistanceFixeNeutre",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Terre") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistanceFixeTerre",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Feu") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistanceFixeFeu",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Eau") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistanceFixeEau",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Résistance Air") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "resistanceFixeAir",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Prospection") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "prospection",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Invocations") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "invocations",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance distance") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceDistance",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Résistance mêlée") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentResistanceMelee",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Dommages mêlée") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentDommagesMelee",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Dommages distance") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pourcentDommagesDistance",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("% Dommages aux sorts") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "dommagesSorts",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                valueInHtml.contains("Pods") -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "pods",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                                else -> {
                                    statisticList.add(
                                        Statistic(
                                            label = "vitalite",
                                            fromTo = getFromToMinValue(valueInHtml)
                                        )
                                    )
                                }
                            }
                        })
                        bonusList.add(
                            Bonus(
                                numberOfItemInPanoplie = numberOfItemInBonus,
                                statistics = statisticList
                            )
                        )
                        panoplieBonus.id = id
                        panoplieBonus.bonus = bonusList
                        numberOfItemInBonus++
                    }
                    jacksonObjectMapper().writeValue(
                        File(javaClass.getResource("/panoplies/$id.json").path),
                        panoplieBonus
                    )
                }
                .join()
            true
        } else {
            println("LA PANOPLIE ID : $id EST DEJA PARSEE")
            false
        }
    }

    private fun getFromToMinValue(valueInHtml: String) = FromTo(valueInHtml.split(" ").toTypedArray()[0].toInt())

    // Pour générer tous les fichiers
    fun createAllJsonFile(setIdList: List<Int>) {
        FileUtils.cleanDirectory(File(javaClass.getResource("/panoplies").path))
        setIdList.forEach { id: Int ->
            File(javaClass.getResource("/panoplies").path, "$id.json").createNewFile()
        }
    }
}