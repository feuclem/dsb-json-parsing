package domain;

import java.util.List;

public class Equipment {
    private int _id;
    private String name;
    private String level;
    private String imgUrl;
    private List<Statistic> statistics;
    private String type;
    private int setId;

    public static String AMULETTE = "Amulette";
    public static String ANNEAU = "Anneau";
    public static String BOTTES = "Bottes";
    public static String BOUCLIER = "Bouclier";
    public static String CAPE = "Cape";
    public static String CEINTURE = "Ceinture";
    public static String CHAPEAU = "Chapeau";
    public static String DOFUS = "Dofus";
    public static String TROPHEE = "Trophée";


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSetId() {
        return setId;
    }

    public void setSetId(int setId) {
        this.setId = setId;
    }
}
