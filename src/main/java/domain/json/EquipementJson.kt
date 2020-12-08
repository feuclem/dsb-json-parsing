package domain.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import domain.Equipement
import domain.StatisticJson

@JsonIgnoreProperties(ignoreUnknown = true)
data class EquipementJson(
    var _id: Int = 0,
    var name: String = "",
    var level: Int = 0,
    var imgUrl: String = "",
    var statistics: List<StatisticJson> = emptyList(),
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

    fun toEquipement() = Equipement(
        _id = this._id,
        name = this.name,
        level = this.level,
        imgUrl = this.imgUrl,
        statistic = this.statistics.map { it.toStatistic() },
        type = this.type,
        setId = this.setId
    )
}