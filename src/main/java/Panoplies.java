import com.google.gson.annotations.SerializedName;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.List;

class Panoplies {
    private int _id;
    private String name;
    private String lvl;
    private List<Bonus> bonus;
    @SerializedName("equipment_id")
    private List<Integer> equipmentIds;
    @SerializedName("weapon_id")
    private List<Integer> armeIds;
    @Ignore
    private List<Equipments> equipments;

    int get_id() {
        return _id;
    }

    void set_id(int _id) {
        this._id = _id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getLvl() {
        return lvl;
    }

    void setLvl(String lvl) {
        this.lvl = lvl;
    }

    List<Bonus> getBonus() {
        return bonus;
    }

    void setBonus(List<Bonus> bonus) {
        this.bonus = bonus;
    }

    List<Equipments> getEquipments() {
        return equipments;
    }

    void setEquipments(List<Equipments> equipments) {
        this.equipments = equipments;
    }

    List<Integer> getEquipmentIds() {
        return equipmentIds;
    }

    void setEquipmentIds(List<Integer> equipmentIds) {
        this.equipmentIds = equipmentIds;
    }

    List<Integer> getArmeIds() {
        return armeIds;
    }

    void setArmeIds(List<Integer> armeIds) {
        this.armeIds = armeIds;
    }
}
