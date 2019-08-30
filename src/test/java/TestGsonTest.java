import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class TestGsonTest {

    private TestGson testGson = new TestGson();

    @Test
    public void deserializedEquipments() throws FileNotFoundException {
        // When
        List<Equipments> eList = testGson.deserializedEquipments();

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
    public void write() throws IOException {
        // When
        testGson.write();
    }
}
