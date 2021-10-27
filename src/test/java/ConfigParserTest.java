import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigParserTest {
    ConfigParser configParser;
    ConfigParser configParser2;
    ConfigParser getMapKeys;

    @BeforeEach
    void setUp() {
        configParser = new ConfigParser("production");
        configParser2 = new ConfigParser("staging");
        getMapKeys = new ConfigParser("staging");
    }


//    @Test
//    void fileMaster() {
//    }

    @Test
    void getValue() {

        // Testing get method in Production environment
        final String expectedOutput = "sq04_db";
        final String actualOutput = configParser.getValue("dbname");
        Assertions.assertEquals(expectedOutput, actualOutput);
        final String expectedOutput2 = "fintek";
        final String actualOutput2 = configParser.getValue("application1.name");
        Assertions.assertEquals(expectedOutput2, actualOutput2);
        final String expectedOutput3 = "fintrack";
        final String actualOutput3 = configParser.getValue("application2.name");
        Assertions.assertEquals(expectedOutput3, actualOutput3);

        // Testing get method in Staging environment
        final String expectedOutput4 = "/api/v1";
        final String actualOutput4 = configParser2.getValue("application1.context-url");
        Assertions.assertEquals(expectedOutput4, actualOutput4);
        final String expectedOutput5 = "fast-staging";
        final String actualOutput5 = configParser2.getValue("pipeline");
        Assertions.assertEquals(expectedOutput5, actualOutput5);

    }
}