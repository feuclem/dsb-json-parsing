package domain

data class Equipement(
    val _id: Int,
    val name: String,
    val level: Int,
    val imgUrl: String,
    val statistic: List<Statistic>,
    val type: String,
    val setId: Int
)