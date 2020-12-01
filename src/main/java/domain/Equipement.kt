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

    fun parseName() {
        when {
            name.contains("% Critique") -> name = "% Critique"
            name.contains("% Résistance Neutre") -> name = "% Résistance Neutre"
            name.contains("% Résistance Terre") -> name = "% Résistance Terre"
            name.contains("% Résistance Feu") -> name = "% Résistance Feu"
            name.contains("% Résistance Eau") -> name = "% Résistance Eau"
            name.contains("% Résistance Air") -> name = "% Résistance Air"
            name.contains("Résistance Neutre") -> name = "Résistance Neutre"
            name.contains("Résistance Terre") -> name = "Résistance Terre"
            name.contains("Résistance Feu") -> name = "Résistance Feu"
            name.contains("Résistance Eau") -> name = "Résistance Eau"
            name.contains("Résistance Air") -> name = "Résistance Air"
            name.contains("Résistance distance") -> name = "Résistance distance"
            name.contains("Résistance mêlée") -> name = "Résistance mêlée"
            name.contains("Dommages distance") -> name = "Dommages distance"
            name.contains("Dommages mêlée") -> name = "Dommages mêlée"
            name.contains("Dommages aux sorts") -> name = "Dommages aux sorts"
        }
    }
}