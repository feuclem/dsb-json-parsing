package runner

import parser.EquipementsParser

object EquipementsRunner {

    fun run() {
        val equipementsPath = javaClass.getResource("/equipements.json").path
        EquipementsParser.writeAmulettes(equipementsPath)
        EquipementsParser.writeAnneaux(equipementsPath)
        EquipementsParser.writeBottes(equipementsPath)
        EquipementsParser.writeBoucliers(equipementsPath)
        EquipementsParser.writeCapes(equipementsPath)
        EquipementsParser.writeCeintures(equipementsPath)
        EquipementsParser.writeCoiffes(equipementsPath)
        EquipementsParser.writeDofus(equipementsPath)
        EquipementsParser.writeTrophees(equipementsPath)
    }
}