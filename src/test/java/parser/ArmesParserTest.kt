package parser

import org.junit.Test
import java.io.IOException

class ArmesParserTest {

    @Test
    fun test() {
        val armesParser = ArmesParser()
        armesParser.writeArcs()
        armesParser.writeBaguettes()
        armesParser.writeBatons()
        armesParser.writeDagues()
        armesParser.writeEpees()
        armesParser.writeFaux()
        armesParser.writeMarteaux()
        armesParser.writePelles()
    }
}