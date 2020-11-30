package domain

data class PanoplieBonus(
    var id: Int = 0,
    var bonus: List<Bonus> = emptyList()
)