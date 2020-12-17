package runner

import parser.PanopliesParser

object PanopliesRunner {
    fun run() {
        PanopliesParser.write(
            equipementsPath = javaClass.getResource("/equipements.json").path,
            panopliesPath = javaClass.getResource("/panoplies.json").path
        )
    }
}