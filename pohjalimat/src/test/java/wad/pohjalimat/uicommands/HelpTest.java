package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author eski
 */
public class HelpTest {

    StubIO testIO;
    ArrayList<Inproceedings> testRefList;
    Help testHelp;
    CommandStash testCommandStash;

    public HelpTest() {
    }

    @Before
    public void setUp() {
        testIO = new StubIO();
        testHelp = new Help(testIO);
        testCommandStash = new CommandStash(testIO);
    }

    @Test
    public void writesALineForEveryCommandToIO() {
        testHelp.run();
        String helpOutput = "";
        for (String line : testIO.getOutput()) {
            helpOutput += line;
        }
        
        for (String command : testCommandStash.commands.keySet()) {
            assertTrue(helpOutput.contains(command));
        }
    }
    
}
