package parser

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import domain.Bonus
import domain.FromTo
import domain.PanoplieBonus
import domain.Statistic
import org.apache.commons.io.FileUtils
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.io.File

class PanoplieBonusParserTest {

    @Before
    fun setup() {
        FileUtils.cleanDirectory(File(javaClass.getResource("/panoplies").path))
        File(javaClass.getResource("/panoplies").path, "274.json").createNewFile()
    }

    @Test
    fun testWrite() {
        val expected = PanoplieBonus(
            id = 274,
            bonus = listOf(
                Bonus(
                    numberOfItemInPanoplie = 2,
                    statistics = listOf(
                        Statistic("vitalite", FromTo(100)),
                        Statistic("puissance", FromTo(50)),
                        Statistic("dommagesCritiques", FromTo(20))
                    )
                ),
                Bonus(
                    numberOfItemInPanoplie = 3,
                    statistics = listOf(
                        Statistic("pa", FromTo(1)),
                        Statistic("dommagesCritiques", FromTo(20)),
                        Statistic("puissance", FromTo(50)),
                        Statistic("vitalite", FromTo(100))
                    )
                )
            )
        )

        val result = PanoplieBonusParser.write(javaClass.getResource("/equipements_test.json").path, false)

        val actual = jacksonObjectMapper().readValue<PanoplieBonus>(File(javaClass.getResource("/panoplies/274.json").path))
        assertEquals(expected, actual)
        assertEquals(listOf(true), result)
    }

    @Test
    fun testNotWriteWhenAlreadyParse() {
        val expected = PanoplieBonus(
            274,
            listOf(
                Bonus(
                    2,
                    listOf(
                        Statistic("vitalite", FromTo(100)),
                        Statistic("puissance", FromTo(50)),
                        Statistic("dommagesCritiques", FromTo(20))
                    )
                ),
                Bonus(
                    3,
                    listOf(
                        Statistic("pa", FromTo(1)),
                        Statistic("dommagesCritiques", FromTo(20)),
                        Statistic("puissance", FromTo(50)),
                        Statistic("vitalite", FromTo(100))
                    )
                )
            )
        )

        val result1 = PanoplieBonusParser.write(javaClass.getResource("/equipements_test.json").path, false)
        val result2 = PanoplieBonusParser.write(javaClass.getResource("/equipements_test.json").path, false)

        val actual = jacksonObjectMapper().readValue<PanoplieBonus>(File(javaClass.getResource("/panoplies/274.json").path))
        assertEquals(expected, actual)
        assertEquals(listOf(true), result1)
        assertEquals(listOf(false), result2)

    }
}