package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Equipment;
import domain.FromTo;
import domain.Statistic;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquipementsParserTest {

    private final EquipementsParser equipementsParser = new EquipementsParser();
    private final String testDir = getClass().getResource("/equipments_test.json").getPath();

    @Test
    public void test() throws IOException {
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
    }

    @Test
    public void deserializedEquipments() throws FileNotFoundException {
        // When
        List<Equipment> eList = equipementsParser.deserializedEquipments(testDir);

        // Then
        Assert.assertEquals(eList.get(0).get_id(), 14094);
        Assert.assertEquals(eList.get(0).getName(), "Amulette du Strigide");
        Assert.assertEquals(eList.get(0).getLevel(), "200");
        Assert.assertEquals(eList.get(0).getType(), "Amulette");
        Assert.assertEquals(eList.get(0).getImgUrl(), "https://s.ankama.com/www/static.ankama.com/dofus/www/game/items/200/1235.png");
        Assert.assertEquals(eList.get(0).getStatistics().get(0).getVitalite().getMin(), "351");
        Assert.assertEquals(eList.get(0).getStatistics().get(0).getVitalite().getMax(), "400");
    }

    @Test
    public void writeInFileTest() throws IOException {
        // Given
        List<Equipment> equipments = new ArrayList();
        Equipment equipment = new Equipment();
        equipment.set_id(14094);
        equipment.setName("Amulette du Strigide");
        equipment.setLevel("200");
        equipment.setType("Amulette");
        equipment.setImgUrl("https://s.ankama.com/www/static.ankama.com/dofus/www/game/items/200/1235.png");
        equipment.setSetId(274);

        List<Statistic> statistics = new ArrayList();
        Statistic vitalite = new Statistic();
        vitalite.setVitalite(new FromTo("0", "10"));
        statistics.add(vitalite);
        Statistic puissance = new Statistic();
        puissance.setPuissance(new FromTo("0", "20"));
        statistics.add(puissance);

        equipment.setStatistics(statistics);
        equipments.add(equipment);

        String path = getClass().getResource("/data/amulettes_test.json").getPath();
        Writer amulettesWriter = new FileWriter(path);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // When
        equipementsParser.writeInFile(equipments, amulettesWriter, gson);
    }
}
