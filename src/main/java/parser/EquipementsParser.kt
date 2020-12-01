package parser

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Equipement
import java.io.File
import java.util.ArrayList

class EquipementsParser {

    companion object {
        private val mapper = ObjectMapper().registerModule(KotlinModule())
    }

    private val equipementsDir = javaClass.getResource("/equipements.json").path
    private val amulettesDir = javaClass.getResource("/equipements/amulettes.json").path
    private val anneauxDir = javaClass.getResource("/equipements/anneaux.json").path
    private val coiffesDir = javaClass.getResource("/equipements/coiffes.json").path
    private val capesDir = javaClass.getResource("/equipements/capes.json").path
    private val dofusDir = javaClass.getResource("/equipements/dofus.json").path
    private val bottesDir = javaClass.getResource("/equipements/bottes.json").path
    private val ceinturesDir = javaClass.getResource("/equipements/ceintures.json").path
    private val tropheesDir = javaClass.getResource("/equipements/trophees.json").path
    private val boucliersDir = javaClass.getResource("/equipements/boucliers.json").path

    fun writeAmulettes() {
        write(amulettesDir, Equipement.AMULETTE)
    }

    fun writeAnneaux() {
        write(anneauxDir, Equipement.ANNEAU)
    }

    fun writeBottes() {
        write(bottesDir, Equipement.BOTTES)
    }

    fun writeBoucliers() {
        write(boucliersDir, Equipement.BOUCLIER)
    }

    fun writeCapes() {
        write(capesDir, Equipement.CAPE)
    }

    fun writeCeintures() {
        write(ceinturesDir, Equipement.CEINTURE)
    }

    fun writeCoiffes() {
        write(coiffesDir, Equipement.CHAPEAU)
    }

    fun writeDofus() {
        write(dofusDir, Equipement.DOFUS)
    }

    fun writeTrophees() {
        write(tropheesDir, Equipement.TROPHEE)
    }

    private fun write(pathWhereToWrite: String, type: String) {
        val equipementsJson: List<Equipement> = deserializedEquipements(equipementsDir)
        val equipements: MutableList<Equipement> = ArrayList<Equipement>()
        equipementsJson.forEach {
            if (it.type == type) {
                equipements.add(it)
            }
        }
        writeInFile(equipements, pathWhereToWrite)
    }

    private fun deserializedEquipements(dir: String): List<Equipement> {
        return mapper.readValue(dir)
    }

    private fun writeInFile(dofus: List<Equipement>, fileToWrite: String) {
        mapper.writeValue(File(fileToWrite), dofus)
    }
}