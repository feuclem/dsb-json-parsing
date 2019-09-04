import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGson {

    final static String equipmentsDir = "/home/octoc/Documents/dsb-data/equipements.json";

    private final static String amulettesDir = "/home/octoc/Documents/dsb-data/customized/amulettes.json";
    private final static String anneauxDir = "/home/octoc/Documents/dsb-data/customized/anneaux.json";
    private final static String coiffesDir = "/home/octoc/Documents/dsb-data/customized/coiffes.json";
    private final static String capesDir = "/home/octoc/Documents/dsb-data/customized/capes.json";
    private final static String dofusDir = "/home/octoc/Documents/dsb-data/customized/dofus.json";
    private final static String bottesDir = "/home/octoc/Documents/dsb-data/customized/bottes.json";
    private final static String ceinturesDir = "/home/octoc/Documents/dsb-data/customized/ceintures.json";

    public List<Equipments> deserializedEquipments(String dir) throws FileNotFoundException {
        Equipments[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Equipments[].class);
        return Arrays.asList(el);
    }

    public void write(String dir) throws IOException {
        List<Equipments> equipmentsList = this.deserializedEquipments(equipmentsDir);
        List<Equipments> amulettes = new ArrayList<>();
        List<Equipments> bottes = new ArrayList<>();
        List<Equipments> ceintures = new ArrayList<>();
        List<Equipments> coiffes = new ArrayList<>();
        List<Equipments> capes = new ArrayList<>();
        List<Equipments> dofus = new ArrayList<>();
        List<Equipments> anneaux = new ArrayList<>();

        Writer amulettesWriter = new FileWriter(amulettesDir);
        Writer bottesWriter = new FileWriter(bottesDir);
        Writer ceinturesWriter = new FileWriter(ceinturesDir);
        Writer anneauxWriter = new FileWriter(anneauxDir);
        Writer coiffesWriter = new FileWriter(coiffesDir);
        Writer capesWriter = new FileWriter(capesDir);
        Writer dofusWriter = new FileWriter(dofusDir);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        equipmentsList.forEach(e -> {
            if (e.getType().equals("Amulette")) {
                amulettes.add(e);
            }
            if (e.getType().equals("Bottes")) {
                bottes.add(e);
            }
            if (e.getType().equals("Ceinture")) {
                ceintures.add(e);
            }
            if (e.getType().equals("Anneau")) {
                anneaux.add(e);
            }
            if (e.getType().equals("Chapeau")) {
                coiffes.add(e);
            }
            if (e.getType().equals("Cape")) {
                capes.add(e);
            }
            if (e.getType().equals("Dofus")) {
                dofus.add(e);
            }
        });

        write(amulettes, amulettesWriter, gson);

        write(bottes, bottesWriter, gson);

        write(ceintures, ceinturesWriter, gson);

        write(anneaux, anneauxWriter, gson);

        write(coiffes, coiffesWriter, gson);

        write(capes, capesWriter, gson);

        write(dofus, dofusWriter, gson);
    }

    private void write(List<Equipments> dofus, Writer dofusWriter, Gson gson) throws IOException {
        gson.toJson(dofus, dofusWriter);
        dofusWriter.flush();
        dofusWriter.close();
    }
}
