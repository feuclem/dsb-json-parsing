package parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Equipement
import domain.Panoplie
import java.io.File

class PanopliesParser {
    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
    }

    private val panopliesDir = javaClass.getResource("/panoplies.json").path
    private val equipementsParser = javaClass.getResource("/equipements.json").path

    fun write() {
        val equipementsJson: List<Equipement> = mapper.readValue(equipementsParser)
        val panopliesJson: List<Panoplie> = mapper.readValue(panopliesDir)
        val panoplieList = panopliesJson.map { panoplie ->
            equipementsJson.filter { equipement ->
                equipement.setId == panoplie._id
            }.let { panoplie.equipments = it }
            panoplie
        }
        println("PANOPLIES PARSER size : " + panoplieList.size)
        writeInFile(panoplieList, javaClass.getResource("/equipements/panoplies.json").path)
    }

    private fun writeInFile(dofus: List<Panoplie>, fileToWrite: String) {
        mapper.writeValue(File(fileToWrite), dofus)
    }
}