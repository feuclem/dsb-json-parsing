package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Equipment;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EquipementsParser {

    private final String amulettesDir = getClass().getResource("/equipements/amulettes.json").getPath();
    private final String anneauxDir = getClass().getResource("/equipements/anneaux.json").getPath();
    private final String coiffesDir = getClass().getResource("/equipements/coiffes.json").getPath();
    private final String capesDir = getClass().getResource("/equipements/capes.json").getPath();
    private final String dofusDir = getClass().getResource("/equipements/dofus.json").getPath();
    private final String bottesDir = getClass().getResource("/equipements/bottes.json").getPath();
    private final String ceinturesDir = getClass().getResource("/equipements/ceintures.json").getPath();
    private final String tropheesDir = getClass().getResource("/equipements/trophees.json").getPath();
    private final String boucliersDir = getClass().getResource("/equipements/boucliers.json").getPath();

    public List<Equipment> deserializedEquipments(String dir) throws FileNotFoundException {
        Equipment[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Equipment[].class);
        return Arrays.asList(el);
    }

    public void writeAmulettes() throws IOException {
        write(amulettesDir, Equipment.AMULETTE);
    }

    public void writeAnneaux() throws IOException {
        write(anneauxDir, Equipment.ANNEAU);
    }

    public void writeBottes() throws IOException {
        write(bottesDir, Equipment.BOTTES);
    }

    public void writeBoucliers() throws IOException {
        write(boucliersDir, Equipment.BOUCLIER);
    }

    public void writeCapes() throws IOException {
        write(capesDir, Equipment.CAPE);
    }

    public void writeCeintures() throws IOException {
        write(ceinturesDir, Equipment.CEINTURE);
    }

    public void writeCoiffes() throws IOException {
        write(coiffesDir, Equipment.CHAPEAU);
    }

    public void writeDofus() throws IOException {
        write(dofusDir, Equipment.DOFUS);
    }

    public void writeTrophees() throws IOException {
        write(tropheesDir, Equipment.TROPHEE);
    }

    public void writeInFile(List<Equipment> dofus, Writer dofusWriter, Gson gson) throws IOException {
        gson.toJson(dofus, dofusWriter);
        dofusWriter.flush();
        dofusWriter.close();
    }

    private void write(String objectDir, String type) throws IOException {
        List<Equipment> equipmentsJson = this.deserializedEquipments(getClass().getResource("/equipements.json").getPath());
        List<Equipment> equipments = new ArrayList<>();
        Writer write = new FileWriter(objectDir);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        equipmentsJson.forEach(e -> {
            if (e.getType().equals(type)) {
                e.parseName();
                equipments.add(e);
            }
        });

        writeInFile(equipments, write, gson);
    }
}
