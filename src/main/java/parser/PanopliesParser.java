package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Equipment;
import domain.Panoplie;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PanopliesParser {

    final String panopliesDir = getClass().getResource("/panoplies.json").getPath();

    public void write(String dir) throws IOException {
        Equipment[] el = new GsonBuilder().create().fromJson(new FileReader(getClass().getResource("/equipements.json").getPath()), Equipment[].class);
        List<Equipment> equipmentList = Arrays.asList(el);
        Panoplie[] pl = new GsonBuilder().create().fromJson(new FileReader(dir), Panoplie[].class);
        List<Panoplie> panoplieList = Arrays.asList(pl);

        panoplieList = panoplieList.stream().peek(panoplie -> {
            List<Equipment> equipmentList1 = equipmentList.stream().filter(equipments -> equipments.getSetId() == panoplie.get_id()).collect(Collectors.toList());
            panoplie.setEquipments(equipmentList1);
        }).collect(Collectors.toList());

        Writer writer = new FileWriter(getClass().getResource("/equipements/panoplies.json").getPath());
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        gson.toJson(panoplieList, writer);
        writer.flush();
        writer.close();
    }
}
