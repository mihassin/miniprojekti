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
public class AddentryTest {
            
    ArrayList<Entry> testRefList;
    StubIO testIO;
    Inproceedings testInproceedings;
    Addentry testAddentry;
    
    public AddentryTest() {
    }
    
    @Before
    public void setUp() {
        testIO = new StubIO();
        testRefList = new ArrayList<Entry>();
        testAddentry = new Addentry(testIO, testRefList);
    }

    @Test
    public void addingANewEntry () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed () {
        testIO = new StubIO("", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed2 () {
        testIO = new StubIO("masterkey", "", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed3 () {
        testIO = new StubIO("masterkey", "writerguy", "", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed4 () {
        testIO = new StubIO("masterkey", "writerguy", "work", "", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed5 () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldsFailsAndUserIsInformed () {
        testIO = new StubIO("", "", "", "", "");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithInvalidPublishYearFailsAndUserIsInformed () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "invalid");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithDuplicateMasterKeyIsHandled () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        testIO = new StubIO("just testing masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();
        
        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
        assertTrue(testRefList.get(2).getMasterKey().equals("masterkey__1"));
        assertTrue(testRefList.get(3).getMasterKey().equals("masterkey__2"));
    }
}
