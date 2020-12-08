package runner

import parser.PanoplieBonusParser

object PanoplieBonusRunner {

    fun run() {
        PanoplieBonusParser.write(
            equipementsPath = javaClass.getResource("/equipements.json").path,
            isNeededToGenerateAllFiles = true
        )
    }
}