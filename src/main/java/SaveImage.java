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
            "/home/octoc/Documents/dsb-data/customized/amulettes.json",
            "/home/octoc/Documents/dsb-data/images/amulettes/"
    );
    SaveDirs anneaux = new SaveDirs(
            "/home/octoc/Documents/dsb-data/customized/anneaux.json",
            "/home/octoc/Documents/dsb-data/images/anneaux/"
    );
    SaveDirs ceintures = new SaveDirs(
            "/home/octoc/Documents/dsb-data/customized/ceintures.json",
            "/home/octoc/Documents/dsb-data/images/ceintures/"
    );
    SaveDirs coiffes = new SaveDirs(
            "/home/octoc/Documents/dsb-data/customized/coiffes.json",
            "/home/octoc/Documents/dsb-data/images/coiffes/"
    );
    SaveDirs capes = new SaveDirs(
            "/home/octoc/Documents/dsb-data/customized/capes.json",
            "/home/octoc/Documents/dsb-data/images/capes/"
    );
    SaveDirs dofus = new SaveDirs(
            "/home/octoc/Documents/dsb-data/customized/dofus.json",
            "/home/octoc/Documents/dsb-data/images/dofus/"
    );

    private List<Equipments> deserialized(String dir) throws FileNotFoundException {
        Equipments[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Equipments[].class);
        return Arrays.asList(el);
    }

    public void handle(SaveDirs dirs) throws IOException {
        List<Equipments> equipmentsList = this.deserialized(dirs.getImgUrl());
        Map<String, String> imgUrlList = new HashMap<>();

        for (Equipments e : equipmentsList) {
            imgUrlList.put(e.getImgUrl(), e.getName().replaceAll("\\s+", ""));
        }

        imgUrlList.forEach((k, v) -> {
            try {
                URL url = new URL(k);
                URLConnection connection = url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.29 Safari/537.36");
                InputStream in = connection.getInputStream();
                OutputStream out = new BufferedOutputStream(new FileOutputStream(dirs.getUrlToSave() + v + ".png"));

                for (int i; (i = in.read()) != -1; ) {
                    out.write(i);
                }
                in.close();
                out.close();
            } catch (Exception ignored) {

            }
        });
    }
}
