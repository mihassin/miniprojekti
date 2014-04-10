package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author eski
 */
public class SaveTest {
              
    ArrayList<Entry> testRefList;
    StubIO testIO;
    Inproceedings testInproceedings;
    Save testSave;
    
    public SaveTest() {
    }
    
    @Before
    public void setUp() {
        testIO = new StubIO();
        testRefList = new ArrayList<Entry>();
        testSave = new Save(testIO, testRefList);
        testInproceedings = Inproceedings.create("masterKey", "writer guy", "sell & buy", "best open source gui", 2014);
        testRefList.add(testInproceedings);
        testInproceedings = Inproceedings.create("second", "second guy", "another one", "once more", 2012);
        testRefList.add(testInproceedings);
    }

    @Test
    public void writesAllEntriesToFile() {    
        testSave.run();
    }
}
