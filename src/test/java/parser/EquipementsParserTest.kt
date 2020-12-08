package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Equipement
import domain.FromTo
import domain.Statistic
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class EquipementsParserTest {

    @Test
    fun testWriteAmulettes() {
        val equipementsPath = javaClass.getResource("/equipements_test.json").path
        val expected = Equipement(
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

        EquipementsParser.writeAmulettes(equipementsPath)
        val actual = jacksonObjectMapper().readValue<List<Equipement>>(File(javaClass.getResource("/equipements/amulettes.json").path)).first()

        assertEquals(expected, actual)
    }
}