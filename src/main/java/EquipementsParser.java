import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquipementsParser {

    final String equipmentsDir = getClass().getResource("equipments.json").getPath();

    private final String amulettesDir = getClass().getResource("data/amulettes.json").getPath();
    private final String anneauxDir = getClass().getResource("data/anneaux.json").getPath();
    private final String coiffesDir = getClass().getResource("data/coiffes.json").getPath();
    private final String capesDir = getClass().getResource("data/capes.json").getPath();
    private final String dofusDir = getClass().getResource("data/dofus.json").getPath();
    private final String bottesDir = getClass().getResource("data/bottes.json").getPath();
    private final String ceinturesDir = getClass().getResource("data/ceintures.json").getPath();
    private final String tropheesDir = getClass().getResource("data/trophees.json").getPath();
    private final String boucliersDir = getClass().getResource("data/boucliers.json").getPath();

    public List<Equipments> deserializedEquipments(String dir) throws FileNotFoundException {
        Equipments[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Equipments[].class);
        return Arrays.asList(el);
    }

    public void write(String dir) throws IOException {
        List<Equipments> equipmentsList = this.deserializedEquipments(dir);
        List<Equipments> amulettes = new ArrayList<>();
        List<Equipments> bottes = new ArrayList<>();
        List<Equipments> ceintures = new ArrayList<>();
        List<Equipments> coiffes = new ArrayList<>();
        List<Equipments> capes = new ArrayList<>();
        List<Equipments> dofus = new ArrayList<>();
        List<Equipments> anneaux = new ArrayList<>();
        List<Equipments> trophees = new ArrayList<>();
        List<Equipments> boucliers = new ArrayList<>();

        Writer amulettesWriter = new FileWriter(amulettesDir);
        Writer bottesWriter = new FileWriter(bottesDir);
        Writer ceinturesWriter = new FileWriter(ceinturesDir);
        Writer anneauxWriter = new FileWriter(anneauxDir);
        Writer coiffesWriter = new FileWriter(coiffesDir);
        Writer capesWriter = new FileWriter(capesDir);
        Writer dofusWriter = new FileWriter(dofusDir);
        Writer tropheesWriter = new FileWriter(tropheesDir);
        Writer boucliersWriter = new FileWriter(boucliersDir);

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
            if (e.getType().equals("Trophée")) {
                trophees.add(e);
            }
            if (e.getType().equals("Bouclier")) {
                boucliers.add(e);
            }
        });

        writeInFile(amulettes, amulettesWriter, gson);

        writeInFile(bottes, bottesWriter, gson);

        writeInFile(ceintures, ceinturesWriter, gson);

        writeInFile(anneaux, anneauxWriter, gson);

        writeInFile(coiffes, coiffesWriter, gson);

        writeInFile(capes, capesWriter, gson);

        writeInFile(dofus, dofusWriter, gson);

        writeInFile(trophees, tropheesWriter, gson);

        writeInFile(boucliers, boucliersWriter, gson);
    }

    public void writeInFile(List<Equipments> dofus, Writer dofusWriter, Gson gson) throws IOException {
        gson.toJson(dofus, dofusWriter);
        dofusWriter.flush();
        dofusWriter.close();
    }
}
