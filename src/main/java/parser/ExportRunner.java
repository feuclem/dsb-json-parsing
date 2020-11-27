package parser;

import parser.EquipementsParser;
import parser.PanopliesParser;
import parser.SaveImage;

import java.io.IOException;

public class ExportRunner {

    public static void handle() throws IOException {
        EquipementsParser equipementsParser = new EquipementsParser();
        equipementsParser.writeAmulettes();
        equipementsParser.writeAnneaux();
        equipementsParser.writeBottes();
        equipementsParser.writeBoucliers();
        equipementsParser.writeCapes();
        equipementsParser.writeCeintures();
        equipementsParser.writeCoiffes();
        equipementsParser.writeDofus();
        equipementsParser.writeTrophees();
        PanopliesParser panopliesParser = new PanopliesParser();
        panopliesParser.write(panopliesParser.panopliesDir);
        SaveImage saveImage = new SaveImage();
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
