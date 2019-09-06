import org.junit.Test;

import java.io.IOException;

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

    @Test
    public void handleTrophees() throws IOException {
        // When
        saveImage.handle(saveImage.trophees);
    }

    @Test
    public void handleArmes() throws IOException {
        // When
        saveImage.handle(saveImage.armes);
    }

    @Test
    public void handleMontures() throws IOException {
        // When
        saveImage.handle(saveImage.montures);
    }

    @Test
    public void handleFamiliers() throws IOException {
        // When
        saveImage.handle(saveImage.familiers);
    }
}
