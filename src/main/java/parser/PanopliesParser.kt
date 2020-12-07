package parser

import Deserializer.readFile
import Serializer.writeListInFile
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Equipement
import domain.Panoplie

class PanopliesParser {

    private val panopliesPath = javaClass.getResource("/panoplies.json").path
    private val equipementsPath = javaClass.getResource("/equipements.json").path

    fun write() {
        val equipementsJson: List<Equipement> = readFile(equipementsPath)
        val panopliesJson: List<Panoplie> = readFile(panopliesPath)
        val panoplieList = panopliesJson.map { panoplie ->
            equipementsJson.filter { equipement ->
                equipement.setId == panoplie._id
            }.let { panoplie.equipments = it }
            panoplie
        }
        println("PANOPLIES PARSER size : " + panoplieList.size)
        writeListInFile(javaClass.getResource("/equipements/panoplies.json").path, panoplieList)
    }
}