package parser;

import org.junit.Test;

public class SaveImageParserTest {

    @Test
    public void test() {
        SaveImageParser saveImage = new SaveImageParser();
        saveImage.handle(saveImage.getAmulettesSaveDirs());
        saveImage.handle(saveImage.getAnneauxSaveDirs());
        saveImage.handle(saveImage.getArmesSaveDirs());
        saveImage.handle(saveImage.getBottesSaveDirs());
        saveImage.handle(saveImage.getBoucliersSaveDirs());
        saveImage.handle(saveImage.getCapesSaveDirs());
        saveImage.handle(saveImage.getCeinturesSaveDirs());
        saveImage.handle(saveImage.getCoiffesSaveDirs());
        saveImage.handle(saveImage.getDofusSaveDirs());
        saveImage.handle(saveImage.getTropheesSaveDirs());
    }

}