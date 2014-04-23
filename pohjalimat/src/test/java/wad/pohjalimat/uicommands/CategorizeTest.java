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
public class CategorizeTest {

    StubIO testIO;
    ArrayList<Entry> testRefList;
    Categorize testCategorize;
    Inproceedings testInproceedings;

    public CategorizeTest() {
    }

    @Before
    public void setUp() {
        testRefList = new ArrayList<Entry>();
        testInproceedings = Inproceedings.create("masterKey", "writer guy", "sell & buy", "best open source gui", 2014);
        testRefList.add(testInproceedings);
        testIO = new StubIO("1", "kategoria");
        testCategorize = new Categorize(testIO, testRefList);
    }

    @Test
    public void addsCategoryToEntry() {
        testCategorize.run();
        assertTrue(testInproceedings.getCategory().equals("kategoria"));
    }
    
    @Test
    public void emptyRefListHandled() {
        testRefList.clear();
        testCategorize.run();
        assertTrue(testInproceedings.getCategory() == null);
        assertTrue(testIO.getOutput().contains("There are no entries!"));
    }
    
    @Test
    public void idiotUserFailsInNumberEntry() {
        testIO = new StubIO("noob");
        testCategorize = new Categorize(testIO, testRefList);
        testCategorize.run();
        assertTrue(testIO.getOutput().contains("Invalid number entry"));
    }
    
    @Test
    public void idiotUserFailsInNumberEntry2() {
        testIO = new StubIO("6");
        testCategorize = new Categorize(testIO, testRefList);
        testCategorize.run();
        assertTrue(testIO.getOutput().contains("Illegal entry number"));
    }
    
}
