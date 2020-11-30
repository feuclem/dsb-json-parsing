package domain

data class Bonus(
    var number: Int = 0,
    var stats: List<Statistic> = emptyList()
)