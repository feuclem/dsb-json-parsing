package parser

import org.junit.Test

class SaveImageParserTest {
    @Test
    fun testHandleAmulettes() {
        SaveImageParser.handle(javaClass.getResource("/equipements_test.json").path, SaveImageParser.amulettesSaveDirs)
    }
}