package wad.pohjalimat.uicommands;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import wad.pohjalimat.io.StubIO;

/**
 *
 * @author eski
 */
public class ExitTest {
            
    StubIO testIO;
    Exit testExit;
    
    public ExitTest() {
    }
    
    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();
    
    @Before
    public void setUp() {
        testIO = new StubIO();
        testExit = new Exit(testIO);
    }

    @Test
    public void exitsForGood() {
        exit.expectSystemExitWithStatus(0);
        testExit.run();
    }
}
