package parser;

import org.junit.Test;

import java.io.IOException;

public class SaveImageParserTest {

    @Test
    public void test() throws IOException {
        SaveImageParser saveImage = new SaveImageParser();
        saveImage.handle(saveImage.amulettes);
        saveImage.handle(saveImage.anneaux);
        saveImage.handle(saveImage.bottes);
        saveImage.handle(saveImage.boucliers);
        saveImage.handle(saveImage.capes);
        saveImage.handle(saveImage.ceintures);
        saveImage.handle(saveImage.coiffes);
        saveImage.handle(saveImage.dofus);
        saveImage.handle(saveImage.trophees);
    }

}