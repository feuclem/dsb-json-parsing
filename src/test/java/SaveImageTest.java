import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import static org.hamcrest.core.Is.is;

public class SaveImageTest {

    private SaveImage saveImage = new SaveImage();

    @Test
    public void handleAmulettes() throws IOException {
        // When
        saveImage.handle(saveImage.amulettes);
    }

    @Test
    public void handleAnneaux() throws IOException {
        // When
        saveImage.handle(saveImage.anneaux);
    }

    @Test
    public void handleCeintures() throws IOException {
        // When
        saveImage.handle(saveImage.ceintures);
    }

    @Test
    public void handleCoiffes() throws IOException {
        // When
        saveImage.handle(saveImage.coiffes);
    }

    @Test
    public void handleCapes() throws IOException {
        // When
        saveImage.handle(saveImage.capes);
    }

    @Test
    public void handleDofus() throws IOException {
        // When
        saveImage.handle(saveImage.dofus);
    }
}
