package parser;

import com.google.gson.GsonBuilder;
import domain.Bonus;
import domain.PanoplieBonus;
import domain.Statistic;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PanoplieBonusParserTest extends TestCase {

    private final PanoplieBonusParser panoplieBonusParser = new PanoplieBonusParser();
    private final String dirPath = getClass().getResource("/panoplies").getPath();

    @Test
    public void test() throws FileNotFoundException {
        panoplieBonusParser.handle();
    }

    @Test
    public void testCreateAllJsonFile() throws IOException {
        // Given
        List<Integer> setIdList = Arrays.asList(274);

        // When
        panoplieBonusParser.createAllJsonFile(setIdList);

        // Then
        File file = new File(dirPath);
        Assert.assertEquals(file.list().length, 1);
    }

    @Test
    public void testWriteInFile() throws IOException {
        // When
        panoplieBonusParser.writeInFile(274);

        // Then
        PanoplieBonus panoplieBonus = new GsonBuilder().create().fromJson(new FileReader(getClass().getResource("/panoplies/274.json").getPath()), PanoplieBonus.class);
        Assert.assertEquals(panoplieBonus.getId(), 274);
        Bonus actualFirstBonus = panoplieBonus.getBonus().get(0);
        Statistic actualVitaFirstStatBonus = actualFirstBonus.getStats().get(0);
        Statistic actualPuissanceFirstStatBonus = actualFirstBonus.getStats().get(1);
        Statistic actualDoCritFirstStatBonus = actualFirstBonus.getStats().get(2);
        Bonus actualSecondBonus = panoplieBonus.getBonus().get(1);
        Statistic actualPASecondStatBonus = actualSecondBonus.getStats().get(0);
        Statistic actualDoCritSecondStatBonus = actualSecondBonus.getStats().get(1);
        Statistic actualPuissanceSecondStatBonus = actualSecondBonus.getStats().get(2);
        Statistic actualVitaSecondStatBonus = actualSecondBonus.getStats().get(3);

        Assert.assertEquals(actualFirstBonus.getNumber(), 2);
        Assert.assertEquals(actualVitaFirstStatBonus.getVitalite().getMin(), "100");
        Assert.assertEquals(actualVitaFirstStatBonus.getVitalite().getMax(), "100");
        Assert.assertEquals(actualPuissanceFirstStatBonus.getPuissance().getMin(), "50");
        Assert.assertEquals(actualPuissanceFirstStatBonus.getPuissance().getMax(), "50");
        Assert.assertEquals(actualDoCritFirstStatBonus.getDommagesCritiques().getMin(), "20");
        Assert.assertEquals(actualDoCritFirstStatBonus.getDommagesCritiques().getMax(), "20");

        Assert.assertEquals(actualSecondBonus.getNumber(), 3);
        Assert.assertEquals(actualPASecondStatBonus.getPa().getMin(), "1");
        Assert.assertEquals(actualPASecondStatBonus.getPa().getMax(), "1");
        Assert.assertEquals(actualDoCritSecondStatBonus.getDommagesCritiques().getMin(), "20");
        Assert.assertEquals(actualDoCritSecondStatBonus.getDommagesCritiques().getMax(), "20");
        Assert.assertEquals(actualPuissanceSecondStatBonus.getPuissance().getMin(), "50");
        Assert.assertEquals(actualPuissanceSecondStatBonus.getPuissance().getMax(), "50");
        Assert.assertEquals(actualVitaSecondStatBonus.getVitalite().getMin(), "100");
        Assert.assertEquals(actualVitaSecondStatBonus.getVitalite().getMax(), "100");

    }
}