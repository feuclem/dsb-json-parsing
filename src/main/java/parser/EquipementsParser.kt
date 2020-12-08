package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Equipement
import domain.json.EquipementJson
import java.io.File

object EquipementsParser {

    private val amulettesPath = javaClass.getResource("/equipements/amulettes.json").path
    private val anneauxPath = javaClass.getResource("/equipements/anneaux.json").path
    private val coiffesPath = javaClass.getResource("/equipements/coiffes.json").path
    private val capesPath = javaClass.getResource("/equipements/capes.json").path
    private val dofusPath = javaClass.getResource("/equipements/dofus.json").path
    private val bottesPath = javaClass.getResource("/equipements/bottes.json").path
    private val ceinturesPath = javaClass.getResource("/equipements/ceintures.json").path
    private val tropheesPath = javaClass.getResource("/equipements/trophees.json").path
    private val boucliersPath = javaClass.getResource("/equipements/boucliers.json").path

    fun writeAmulettes(equipementsPath: String) {
        write(equipementsPath, amulettesPath, EquipementJson.AMULETTE)
    }

    fun writeAnneaux(equipementsPath: String) {
        write(equipementsPath, anneauxPath, EquipementJson.ANNEAU)
    }

    fun writeBottes(equipementsPath: String) {
        write(equipementsPath, bottesPath, EquipementJson.BOTTES)
    }

    fun writeBoucliers(equipementsPath: String) {
        write(equipementsPath, boucliersPath, EquipementJson.BOUCLIER)
    }

    fun writeCapes(equipementsPath: String) {
        write(equipementsPath, capesPath, EquipementJson.CAPE)
    }

    fun writeCeintures(equipementsPath: String) {
        write(equipementsPath, ceinturesPath, EquipementJson.CEINTURE)
    }

    fun writeCoiffes(equipementsPath: String) {
        write(equipementsPath, coiffesPath, EquipementJson.CHAPEAU)
    }

    fun writeDofus(equipementsPath: String) {
        write(equipementsPath, dofusPath, EquipementJson.DOFUS)
    }

    fun writeTrophees(equipementsPath: String) {
        write(equipementsPath, tropheesPath, EquipementJson.TROPHEE)
    }

    private fun write(equipementsPath: String, pathWhereToWrite: String, type: String) {
        val equipementsJson = jacksonObjectMapper().readValue<List<EquipementJson>>(File(equipementsPath))
        val equipements: MutableList<Equipement> = mutableListOf()
        equipementsJson.forEach {
            if (it.type == type) {
                equipements.add(it.toEquipement())
            }
        }
        println("EQUIPEMENT PARSER pour : $type , size : ${equipements.size}")
        jacksonObjectMapper().writeValue(File(pathWhereToWrite), equipements)
    }
}