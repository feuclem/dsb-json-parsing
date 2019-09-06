import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class EquipementsParserTest {

    private EquipementsParser equipementsParser = new EquipementsParser();
    private String testDir = "/home/octoc/Documents/dsb-data/equipements_test.json";

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
    public void writeWithTest() throws IOException {
        // When
        equipementsParser.write(testDir);
    }

    @Test
    public void write() throws IOException {
        // When
        equipementsParser.write(EquipementsParser.equipmentsDir);
    }

    @Test
    public void writeMontures() throws IOException {
        // When
        equipementsParser.deserializedMontures();
    }

    @Test
    public void writeFamilers() throws IOException {
        // When
        equipementsParser.deserializedFamiliers();
    }

    @Test
    public void writeArmes() throws IOException {
        // When
        equipementsParser.deserializedArmes();
    }

    @Test
    public void writePanoplies() throws IOException {
        // When
        equipementsParser.deserializedPanoplies();
    }
}
