package domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Equipment {
    private int _id;
    private String name;
    @SerializedName("level")
    private String lvl;
    private String imgUrl;
    @SerializedName("statistics")
    private List<Statistic> stats;
    private String type;
    private int setId;

    public static String AMULETTE = "Amulette";
    public static String BOTTES = "Bottes";
    public static String CEINTURE = "Ceinture";
    public static String ANNEAU = "Anneau";
    public static String CHAPEAU = "Chapeau";
    public static String CAPE = "Cape";
    public static String DOFUS = "Dofus";
    public static String TROPHEE = "Trophée";
    public static String BOUCLIER = "Bouclier";


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

    public String getLvl() {
        return lvl;
    }

    public void setLvl(String lvl) {
        this.lvl = lvl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<Statistic> getStats() {
        return stats;
    }

    public void setStats(List<Statistic> stats) {
        this.stats = stats;
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
