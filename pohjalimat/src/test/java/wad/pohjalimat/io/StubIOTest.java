

package wad.pohjalimat.io;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class StubIOTest {
    StubIO stubio;


    @Before
    public void setUp() {
        stubio = new StubIO("hessu", "make");
    }
    
    @Test
    public void constructorInputWorks() {
        assertEquals("hessu", stubio.read(""));
        assertEquals("make", stubio.read(""));
    }
    
    @Test
    public void writeInputWorks() {
        stubio.write("data");
        assertTrue(stubio.getOutput().contains("data"));
    }
    
    @Test
    public void returnEmptyStringIfNoInputLeft() {
        stubio.read("");
        stubio.read("");
        assertEquals("", stubio.read(""));
    }





}