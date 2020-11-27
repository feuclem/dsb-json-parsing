package domain;

import java.util.List;

public class Arme {
    private int _id;
    private String name;
    private String level;
    private String imgUrl;
    private List<Statistic> statistics;
    private String type;
    private int setId;
    private List<ArmeCharacteristique> characteristics;

    public static String ARC = "Arc";
    public static String BAGUETTE = "Baguette";
    public static String BATON = "Bâton";
    public static String DAGUE = "Dague";
    public static String EPEE = "Épée";
    public static String FAUX = "Faux";
    public static String MARTEAU = "Marteau";
    public static String PELLE = "Pelle";

    public String getType() {
        return type;
    }
}
