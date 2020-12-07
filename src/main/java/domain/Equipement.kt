package domain

data class Equipement(
    var _id: Int = 0,
    var name: String = "",
    var level: String = "",
    var imgUrl: String = "",
    var statistics: List<Statistic> = emptyList(),
    var type: String = "",
    var setId: Int = 0
) {

    companion object {
        const val AMULETTE = "Amulette"
        const val ANNEAU = "Anneau"
        const val BOTTES = "Bottes"
        const val BOUCLIER = "Bouclier"
        const val CAPE = "Cape"
        const val CEINTURE = "Ceinture"
        const val CHAPEAU = "Chapeau"
        const val DOFUS = "Dofus"
        const val TROPHEE = "Trophée"
    }
}