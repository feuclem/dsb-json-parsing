package domain.json

import domain.StatisticJson

data class BonusJson(
    val number: Int,
    val stats: List<StatisticJson>
)