package domain.json

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import domain.Arme
import domain.ArmeCharacteristique
import domain.StatisticJson

@JsonIgnoreProperties(ignoreUnknown = true)
data class ArmeJson(
    var _id: Int = 0,
    val name: String = "",
    val level: Int = 0,
    val imgUrl: String = "",
    val statistics: List<StatisticJson> = emptyList(),
    val type: String = "",
    val setId: Int = 0,
    val characteristics: List<ArmeCharacteristiqueJson> = emptyList()
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

    fun toArme() = Arme(
        _id = this._id,
        name = this.name,
        level = this.level,
        imgUrl = this.imgUrl,
        statistic = this.statistics.map { it.toStatistic() },
        type = this.type,
        setId = this.setId,
        armeCharacteristique = this.characteristics.let { list ->
            val pa = list.find { armeCharacteristiqueJson -> armeCharacteristiqueJson.pa != "" }!!.pa
            val po = list.find { armeCharacteristiqueJson -> armeCharacteristiqueJson.po != "" }!!.po
            val critique = list.find { armeCharacteristiqueJson -> armeCharacteristiqueJson.critique != "" }!!.critique
            ArmeCharacteristique(pa, po, critique)
        }
    )
}