package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Bonus
import domain.Equipement
import domain.FromTo
import domain.Panoplie
import domain.Statistic
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class PanopliesParserTest {

    @Test
    fun testWrite() {
        val expected = listOf(
            Panoplie(
                274,
                "Panoplie du Strigide",
                200,
                Bonus(
                    numberOfItemInPanoplie = 3,
                    statistics = listOf(
                        Statistic("pa", FromTo(1)),
                        Statistic("dommagesCritiques", FromTo(20)),
                        Statistic("puissance", FromTo(50)),
                        Statistic("vitalite", FromTo(100))
                    )
                ),
                equipments = listOf(
                    Equipement(
                        _id= 14094,
                        name = "Amulette du Strigide",
                        level = 200,
                        imgUrl = "https://s.ankama.com/www/static.ankama.com/dofus/www/game/items/200/1235.png",
                        type = "Amulette",
                        statistic = listOf(
                            Statistic("vitalite", FromTo(351, 400)),
                            Statistic("sagesse", FromTo(31, 40)),
                            Statistic("critique", FromTo(4, 6)),
                            Statistic("puissance", FromTo(51, 70)),
                            Statistic("pa", FromTo(1, 1)),
                            Statistic("pourcentResistanceTerre", FromTo(6, 8)),
                            Statistic("pourcentResistanceAir", FromTo(6, 8)),
                            Statistic("esquivePa", FromTo(4, 6)),
                            Statistic("tacle", FromTo(11, 15)),
                            Statistic("dommagesCritiques", FromTo(16, 25)),
                            Statistic("resistanceCritiques", FromTo(-16, -20))
                        ),
                        setId = 274
                    )
                )
            )
        )

        PanopliesParser.write(
            equipementsPath = javaClass.getResource("/equipements_test.json").path,
            panopliesPath = javaClass.getResource("/panoplies_test.json").path
        )

        val actual = jacksonObjectMapper().readValue<List<Panoplie>>(File(javaClass.getResource("/equipements/panoplies.json").path))
        assertEquals(expected, actual)
    }
}