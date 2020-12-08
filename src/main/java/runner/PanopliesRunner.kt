package runner

import parser.PanopliesParser

object PanopliesRunner {
    fun run() {
        PanopliesParser.write(
            equipementsPath = javaClass.getResource("/panoplies.json").path,
            panopliesPath = javaClass.getResource("/equipements.json").path
        )
    }
}