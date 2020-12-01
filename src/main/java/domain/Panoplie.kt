package domain

import com.fasterxml.jackson.annotation.JsonProperty

data class Panoplie(
    var _id: Int = 0,
    var name: String = "",
    var level: String = "",
    var bonus: Bonus = Bonus(0, emptyList()),
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var equipments: List<Equipement> = emptyList()
) {
}