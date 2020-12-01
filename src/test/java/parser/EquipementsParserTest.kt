package parser

import org.junit.Test

class EquipementsParserTest {

    @Test
    fun test() {
        val equipementsParser = EquipementsParser()
        equipementsParser.writeAmulettes()
        equipementsParser.writeAnneaux()
        equipementsParser.writeBottes()
        equipementsParser.writeBoucliers()
        equipementsParser.writeCapes()
        equipementsParser.writeCeintures()
        equipementsParser.writeCoiffes()
        equipementsParser.writeDofus()
        equipementsParser.writeTrophees()
    }
}