package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author eski
 */
public class BibtexTest {
              
    ArrayList<Entry> testRefList;
    StubIO testIO;
    Inproceedings testInproceedings;
    Bibtex testBibtex;
    
    public BibtexTest() {
    }
    
    @Before
    public void setUp() {
        testIO = new StubIO();
        testRefList = new ArrayList<Entry>();
        testBibtex = new Bibtex(testIO, testRefList);
        testInproceedings = Inproceedings.create("masterKey", "writer guy", "sell & buy", "best open source gui", 2014);
        testRefList.add(testInproceedings);
    }

    @Test
    public void writesToIO() {    
        testBibtex.run();
        assertTrue(testIO.getOutput().contains(testInproceedings.showEntryInBibTeX()));
    }
}
