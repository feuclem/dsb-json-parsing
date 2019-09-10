import org.junit.Test;

import java.io.IOException;

public class PanopliesParserTest {
    private PanopliesParser panopliesParser = new PanopliesParser();

    @Test
    public void handlePanoplies() throws IOException {
        // When
        panopliesParser.deserializedPanoplies();
    }
}
