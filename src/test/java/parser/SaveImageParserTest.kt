package parser

import org.junit.Test

class SaveImageParserTest {
    @Test
    fun test() {
        val saveImage = SaveImageParser()
        saveImage.handle(saveImage.amulettesSaveDirs)
        saveImage.handle(saveImage.anneauxSaveDirs)
        saveImage.handle(saveImage.armesSaveDirs)
        saveImage.handle(saveImage.bottesSaveDirs)
        saveImage.handle(saveImage.boucliersSaveDirs)
        saveImage.handle(saveImage.capesSaveDirs)
        saveImage.handle(saveImage.ceinturesSaveDirs)
        saveImage.handle(saveImage.coiffesSaveDirs)
        saveImage.handle(saveImage.dofusSaveDirs)
        saveImage.handle(saveImage.monturesSaveDirs)
        saveImage.handle(saveImage.tropheesSaveDirs)
    }
}