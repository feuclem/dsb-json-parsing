import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PanopliesParser {

    public void deserializedPanoplies() throws IOException {
        Equipments[] el = new GsonBuilder().create().fromJson(new FileReader("/home/octoc/Documents/dsb-data/equipements.json"), Equipments[].class);
        List<Equipments> equipmentsList = Arrays.asList(el);
        Panoplies[] pl = new GsonBuilder().create().fromJson(new FileReader("/home/octoc/Documents/dsb-data/panoplies.json"), Panoplies[].class);
        List<Panoplies> panopliesList = Arrays.asList(pl);

        panopliesList = panopliesList.stream().peek(panoplies -> {
            List<Equipments> equipmentsList1 = equipmentsList.stream().filter(equipments -> equipments.getSetId() == panoplies.get_id()).collect(Collectors.toList());
            panoplies.setEquipments(equipmentsList1);
        }).collect(Collectors.toList());

        Writer writer = new FileWriter("/home/octoc/Documents/dsb-data/customized/panoplies.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(panopliesList, writer);
        writer.flush();
        writer.close();
    }
}
