import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class Panoplie {
    private int _id;
    private String name;
    @SerializedName("level")
    private String lvl;
    private Bonus bonus;
    @Expose(deserialize = false)
    private List<Equipment> equipments;

    int get_id() {
        return _id;
    }

    void setEquipments(List<Equipment> equipment) {
        this.equipments = equipment;
    }
}
