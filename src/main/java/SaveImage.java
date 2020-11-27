import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveImage {

    SaveDirs amulettes = new SaveDirs(
            getClass().getResource("data/amulettes.json").getPath(),
            getClass().getResource("images/amulettes/").getPath()
    );
    SaveDirs anneaux = new SaveDirs(
            getClass().getResource("data/anneaux.json").getPath(),
            getClass().getResource("images/anneaux/").getPath()
    );
    SaveDirs ceintures = new SaveDirs(
            getClass().getResource("data/ceintures.json").getPath(),
            getClass().getResource("images/ceintures/").getPath()
    );
    SaveDirs coiffes = new SaveDirs(
            getClass().getResource("data/coiffes.json").getPath(),
            getClass().getResource("images/coiffes/").getPath()
    );
    SaveDirs capes = new SaveDirs(
            getClass().getResource("data/capes.json").getPath(),
            getClass().getResource("images/capes/").getPath()
    );
    SaveDirs dofus = new SaveDirs(
            getClass().getResource("data/dofus.json").getPath(),
            getClass().getResource("images/dofus/").getPath()
    );
    SaveDirs trophees = new SaveDirs(
            getClass().getResource("data/trophees.json").getPath(),
            getClass().getResource("images/trophees/").getPath()
    );
//    SaveDirs armes = new SaveDirs(
//            getClass().getResource("data/armes.json").getPath(),
//            getClass().getResource("images/armes/").getPath()
//    );
    SaveDirs montures = new SaveDirs(
            getClass().getResource("data/montures.json").getPath(),
            getClass().getResource("images/montures/").getPath()
    );
    SaveDirs familiers = new SaveDirs(
            getClass().getResource("data/familiers.json").getPath(),
            getClass().getResource("images/familiers/").getPath()
    );
    SaveDirs bottes = new SaveDirs(
            getClass().getResource("data/bottes.json").getPath(),
            getClass().getResource("images/bottes/").getPath()
    );
    SaveDirs boucliers = new SaveDirs(
            getClass().getResource("data/boucliers.json").getPath(),
            getClass().getResource("images/boucliers/").getPath()
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
