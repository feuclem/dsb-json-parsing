package domain

data class Panoplie(
    val _id: Int,
    val name: String,
    val level: Int,
    val bonus: Bonus,
    var equipments: List<Equipement>
)