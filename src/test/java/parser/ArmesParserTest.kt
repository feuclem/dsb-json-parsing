package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Arme
import domain.ArmeCharacteristique
import domain.FromTo
import domain.Statistic
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import java.io.File

class ArmesParserTest {

    @Test
    fun testWriteEpees() {
        val armesPath = javaClass.getResource("/armes_test.json").path
        val expected = Arme(
            _id= 11744,
            name = "Epée Toche",
            level = 196,
            imgUrl = "https://s.ankama.com/www/static.ankama.com/dofus/www/game/items/200/6106.png",
            type = "Épée",
            statistic = listOf(
                Statistic("dommagesArmeNeutre", FromTo(16, 30)),
                Statistic("dommagesArmeTerre", FromTo(16, 30)),
                Statistic("volArmeFeu", FromTo(5, 6)),
                Statistic("vitalite", FromTo(201, 250)),
                Statistic("force", FromTo(31, 50)),
                Statistic("intelligence", FromTo(31, 50)),
                Statistic("sagesse", FromTo(31, 50)),
                Statistic("critique", FromTo(4, 5)),
                Statistic("initiative", FromTo(201, 300)),
                Statistic("prospection", FromTo(11, 15)),
                Statistic("dommagesNeutre", FromTo(8, 12)),
                Statistic("dommagesTerre", FromTo(8, 12)),
                Statistic("dommagesFeu", FromTo(8, 12)),
                Statistic("resistanceFixeEau", FromTo(7, 10)),
                Statistic("pourcentResistanceTerre", FromTo(7, 10)),
                Statistic("retraitPm", FromTo(4, 5))
            ),
            armeCharacteristique = ArmeCharacteristique(
                pa = "5 (1 utilisation par tour)",
                po = "1",
                critique = "1/15 (+7)"
            ),
            setId = 0
        )

        ArmesParser.writeEpees(armesPath)
        val actual = jacksonObjectMapper().readValue<List<Arme>>(File(javaClass.getResource("/armes/epees.json").path)).first()

        assertEquals(expected, actual)
    }
}