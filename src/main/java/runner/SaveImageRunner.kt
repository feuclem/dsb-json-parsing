package runner

import parser.SaveImageParser

object SaveImageRunner {

    fun run() {
        val equipementsPath = javaClass.getResource("/equipements.json").path
        SaveImageParser.handle(equipementsPath, SaveImageParser.amulettesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.anneauxSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.boucliersSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.capesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.ceinturesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.coiffesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.dofusSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.familiersSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.monturesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.tropheesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.arcsSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.baguettesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.batonsSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.daguesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.epeesSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.fauxSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.marteauxSaveDirs)
        SaveImageParser.handle(equipementsPath, SaveImageParser.pellesSaveDirs)
    }
}