package parser

import Deserializer.readFile
import Serializer.writeListInFile
import domain.Equipement
import java.util.ArrayList

class EquipementsParser {

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
        val equipementsJson: List<Equipement> = readFile(equipementsDir)
        val equipements: MutableList<Equipement> = ArrayList<Equipement>()
        equipementsJson.forEach {
            if (it.type == type) {
                equipements.add(it)
            }
        }
        println("EQUIPEMENT PARSER pour : $type , size : ${equipements.size}")
        writeListInFile(pathWhereToWrite, equipements)
    }
}