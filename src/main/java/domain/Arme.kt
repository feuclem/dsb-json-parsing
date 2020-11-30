package domain

data class Arme(
    var _id: Int = 0,
    val name: String = "",
    val level: String = "",
    val imgUrl: String = "",
    val statistics: List<Statistic> = emptyList(),
    val type: String = "",
    val setId: Int = 0,
    val characteristics: List<ArmeCharacteristique> = emptyList()
) {
    companion object {
        const val ARC = "Arc"
        const val BAGUETTE = "Baguette"
        const val BATON = "Bâton"
        const val DAGUE = "Dague"
        const val EPEE = "Épée"
        const val FAUX = "Faux"
        const val MARTEAU = "Marteau"
        const val PELLE = "Pelle"
    }
}