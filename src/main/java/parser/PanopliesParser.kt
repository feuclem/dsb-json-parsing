package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.json.EquipementJson
import domain.Panoplie
import domain.json.PanoplieJson
import java.io.File

object PanopliesParser {

    fun write(equipementsPath: String, panopliesPath: String) {
        val equipementsJson = jacksonObjectMapper().readValue<List<EquipementJson>>(File(equipementsPath))
        val panopliesJson = jacksonObjectMapper().readValue<List<PanoplieJson>>(File(panopliesPath))
        val panoplies = panopliesJson.map { panoplieJson ->
            panoplieJson.toPanoplie(
                equipementsJson.filter { equipement ->
                    equipement.setId == panoplieJson._id
                }
            )
        }
        println("PANOPLIES PARSER size : " + panoplies.size)
        jacksonObjectMapper().writeValue(File(javaClass.getResource("/equipements/panoplies.json").path), panoplies)
    }
}