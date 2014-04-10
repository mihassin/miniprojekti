package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author eski
 */
public class PrintTest {
    
    ArrayList<Entry> testRefList;
    StubIO testIO;
    Inproceedings testInproceedings;
    Print testPrint;
    
    public PrintTest() {
    }
    
    @Before
    public void setUp() {
        testIO = new StubIO();
        testRefList = new ArrayList<Entry>();
        testPrint = new Print(testIO, testRefList);
        testInproceedings = Inproceedings.create("masterKey", "writer guy", "sell & buy", "best open source gui", 2014);
        testRefList.add(testInproceedings);
    }

    @Test
    public void writesToIO() {    
        testPrint.run();
        assertTrue(testIO.getOutput().contains(testInproceedings.toString()));
    }
}
