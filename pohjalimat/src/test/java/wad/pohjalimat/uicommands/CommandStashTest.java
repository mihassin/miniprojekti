package wad.pohjalimat.uicommands;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author eski
 */
public class CommandStashTest {
            
    StubIO testIO;
    CommandStash testStash;
    
    public CommandStashTest() {
    }
    
    @Before
    public void setUp() {
        testStash = new CommandStash(testIO);
        testStash.getRefList().add(Inproceedings.create("masterkey", "writerboy", "test x", "test y", 2014));
    }

    @Test
    public void testGetRefList() {
        assertEquals(testStash.getRefList().get(0).getMasterKey(), "masterkey");
    }
    
    @Test
    public void testGetCommand() {
        assertEquals(new Print(testIO, testStash.getRefList()).getClass(), testStash.get("print").getClass());
    }
    
    @Test
    public void testUnknownCommandActsLikeHelpCommand() {
        assertEquals(new Help(testIO).getClass(), testStash.get("aw48rahpw4xr").getClass());
    }
}
