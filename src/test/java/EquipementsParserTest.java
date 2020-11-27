import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EquipementsParserTest {

    private EquipementsParser equipementsParser = new EquipementsParser();
    private String testDir = getClass().getResource("equipments_test.json").getPath();

    @Test
    public void deserializedEquipments() throws FileNotFoundException {
        // When
        List<Equipments> eList = equipementsParser.deserializedEquipments(testDir);

        // Then
        Assert.assertEquals(eList.get(0).get_id(), 14094);
        Assert.assertEquals(eList.get(0).getName(), "Amulette du Strigide");
        Assert.assertEquals(eList.get(0).getLvl(), "200");
        Assert.assertEquals(eList.get(0).getType(), "Amulette");
        Assert.assertEquals(eList.get(0).getImgUrl(), "https://s.ankama.com/www/static.ankama.com/dofus/www/game/items/200/1235.png");
        Assert.assertEquals(eList.get(0).getStats().get(0).getVitalite().getFrom(), "351");
        Assert.assertEquals(eList.get(0).getStats().get(0).getVitalite().getTo(), "400");
    }

    @Test
    public void writeInFileTest() throws IOException {
        // Given
        List<Equipments> equipments = new ArrayList();
        Equipments equipment = new Equipments();
        equipment.set_id(14094);
        equipment.setName("Amulette du Strigide");
        equipment.setLvl("200");
        equipment.setType("Amulette");
        equipment.setImgUrl("https://s.ankama.com/www/static.ankama.com/dofus/www/game/items/200/1235.png");

        List<Statistic> statistics = new ArrayList();
        Statistic statistic = new Statistic();
        statistic.setVitalite(new FromTo("0", "10"));
        statistics.add(statistic);

        equipment.setStats(statistics);
        equipments.add(equipment);

        String path = getClass().getResource("data/amulettes_test.json").getPath();
        Writer amulettesWriter = new FileWriter(path);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // When
        equipementsParser.writeInFile(equipments, amulettesWriter, gson);
    }

    @Test
    public void write() throws IOException {
        // When
        equipementsParser.write(equipementsParser.equipmentsDir);
    }
}
