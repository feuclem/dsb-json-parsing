package domain.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import domain.Bonus
import domain.Panoplie

@JsonIgnoreProperties(ignoreUnknown = true)
data class PanoplieJson(
    val _id: Int,
    val name: String,
    val level: Int,
    val bonus: BonusJson
) {
    fun toPanoplie(equipements: List<EquipementJson>) =
        Panoplie(
            _id = this._id,
            name = this.name,
            level = this.level,
            bonus = Bonus(
                this.bonus.number + 1,
                this.bonus.stats.map { it.toStatistic() }
            ),
            equipments = equipements.map { it.toEquipement() }
        )
}