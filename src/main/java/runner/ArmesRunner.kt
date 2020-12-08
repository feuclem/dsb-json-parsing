package runner

import parser.ArmesParser

object ArmesRunner {

    fun run() {
        val armesPath = javaClass.getResource("/armes.json").path
        ArmesParser.writeArcs(armesPath)
        ArmesParser.writeBaguettes(armesPath)
        ArmesParser.writeBatons(armesPath)
        ArmesParser.writeDagues(armesPath)
        ArmesParser.writeEpees(armesPath)
        ArmesParser.writeFaux(armesPath)
        ArmesParser.writeMarteaux(armesPath)
        ArmesParser.writePelles(armesPath)
    }
}