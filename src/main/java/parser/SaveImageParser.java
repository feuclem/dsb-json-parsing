package parser;

import com.google.gson.GsonBuilder;
import domain.Equipment;
import domain.SaveDirs;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveImageParser {

    SaveDirs amulettes = new SaveDirs(
            getClass().getResource("/equipements/amulettes.json").getPath(),
            getClass().getResource("/images/amulettes/").getPath()
    );
    SaveDirs anneaux = new SaveDirs(
            getClass().getResource("/equipements/anneaux.json").getPath(),
            getClass().getResource("/images/anneaux/").getPath()
    );
    SaveDirs ceintures = new SaveDirs(
            getClass().getResource("/equipements/ceintures.json").getPath(),
            getClass().getResource("/images/ceintures/").getPath()
    );
    SaveDirs coiffes = new SaveDirs(
            getClass().getResource("/equipements/coiffes.json").getPath(),
            getClass().getResource("/images/coiffes/").getPath()
    );
    SaveDirs capes = new SaveDirs(
            getClass().getResource("/equipements/capes.json").getPath(),
            getClass().getResource("/images/capes/").getPath()
    );
    SaveDirs dofus = new SaveDirs(
            getClass().getResource("/equipements/dofus.json").getPath(),
            getClass().getResource("/images/dofus/").getPath()
    );
    SaveDirs trophees = new SaveDirs(
            getClass().getResource("/equipements/trophees.json").getPath(),
            getClass().getResource("/images/trophees/").getPath()
    );
//    domain.SaveDirs armes = new domain.SaveDirs(
//            getClass().getResource("data/armes.json").getPath(),
//            getClass().getResource("images/armes/").getPath()
//    );
    SaveDirs montures = new SaveDirs(
            getClass().getResource("/equipements/montures.json").getPath(),
            getClass().getResource("/images/montures/").getPath()
    );
    SaveDirs familiers = new SaveDirs(
            getClass().getResource("/equipements/familiers.json").getPath(),
            getClass().getResource("/images/familiers/").getPath()
    );
    SaveDirs bottes = new SaveDirs(
            getClass().getResource("/equipements/bottes.json").getPath(),
            getClass().getResource("/images/bottes/").getPath()
    );
    SaveDirs boucliers = new SaveDirs(
            getClass().getResource("/equipements/boucliers.json").getPath(),
            getClass().getResource("/images/boucliers/").getPath()
    );

    public void handle(SaveDirs dirs) throws IOException {
        List<Equipment> equipmentList = this.deserialized(dirs.getJsonPath());
        Map<String, String> imgUrlList = new HashMap<>();

        for (Equipment e : equipmentList) {
            imgUrlList.put(e.getImgUrl(), e.getName().replaceAll("\\s+", ""));
        }

        imgUrlList.forEach((k, v) -> {
            try {
                URL url = new URL(k);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
                InputStream in = connection.getInputStream();
                OutputStream out = new BufferedOutputStream(new FileOutputStream(dirs.getPathToSave() + v + ".png"));

                for (int i; (i = in.read()) != -1; ) {
                    out.write(i);
                }
                in.close();
                out.close();
            } catch (Exception ignored) {

            }
        });
    }

    private List<Equipment> deserialized(String dir) throws FileNotFoundException {
        Equipment[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Equipment[].class);
        return Arrays.asList(el);
    }
}
