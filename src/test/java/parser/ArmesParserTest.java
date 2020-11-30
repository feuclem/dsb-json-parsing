package parser;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

public class ArmesParserTest {

    @Test
    public void test() throws IOException {
        ArmesParser armesParser = new ArmesParser();
        armesParser.writeArcs();
        armesParser.writeBaguettes();
        armesParser.writeBatons();
        armesParser.writeDagues();
        armesParser.writeEpees();
        armesParser.writeFaux();
        armesParser.writeMarteaux();
        armesParser.writePelles();
    }

}