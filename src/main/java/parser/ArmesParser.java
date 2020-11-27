package parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.Arme;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArmesParser {
    final String armesDir = getClass().getResource("/armes.json").getPath();

    private final String arcsDir = getClass().getResource("/armes/arcs.json").getPath();
    private final String baguettesDir = getClass().getResource("/armes/baguettes.json").getPath();
    private final String batonsDir = getClass().getResource("/armes/batons.json").getPath();
    private final String daguesDir = getClass().getResource("/armes/dagues.json").getPath();
    private final String epeesDir = getClass().getResource("/armes/epees.json").getPath();
    private final String fauxDir = getClass().getResource("/armes/faux.json").getPath();
    private final String marteauxDir = getClass().getResource("/armes/marteaux.json").getPath();
    private final String pellesDir = getClass().getResource("/armes/pelles.json").getPath();

    public List<Arme> deserializedArmes(String dir) throws FileNotFoundException {
        Arme[] el = new GsonBuilder().create().fromJson(new FileReader(dir), Arme[].class);
        return Arrays.asList(el);
    }

    public void writeArcs() throws IOException {
        write(arcsDir, Arme.ARC);
    }
    public void writeBaguettes() throws IOException {
        write(baguettesDir, Arme.BAGUETTE);
    }
    public void writeBatons() throws IOException {
        write(batonsDir, Arme.BATON);
    }
    public void writeDagues() throws IOException {
        write(daguesDir, Arme.DAGUE);
    }
    public void writeEpees() throws IOException {
        write(epeesDir, Arme.EPEE);
    }
    public void writeFaux() throws IOException {
        write(fauxDir, Arme.FAUX);
    }
    public void writeMarteaux() throws IOException {
        write(marteauxDir, Arme.MARTEAU);
    }
    public void writePelles() throws IOException {
        write(pellesDir, Arme.PELLE);
    }

    private void write(String objectDir, String type) throws IOException {
        List<Arme> armesJson = this.deserializedArmes(armesDir);
        List<Arme> armes = new ArrayList<>();
        Writer write = new FileWriter(objectDir);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        armesJson.forEach(e -> {
            if (e.getType().equals(type)) {
                armes.add(e);
            }
        });

        writeInFile(armes, write, gson);
    }

    public void writeInFile(List<Arme> dofus, Writer dofusWriter, Gson gson) throws IOException {
        gson.toJson(dofus, dofusWriter);
        dofusWriter.flush();
        dofusWriter.close();
    }
}
