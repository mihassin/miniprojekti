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
 * @author eski & co
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
    public void addingANewInproceedingsEntry() {
        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
    }

    @Test
    public void addingANewInproceedingsEntryWithEmptyRequiredFieldFailsAndUserIsInformed() {
        testIO = new StubIO("inproceedings", "", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewInproceedingsEntryWithEmptyRequiredFieldFailsAndUserIsInformed2() {
        testIO = new StubIO("inproceedings", "masterkey", "", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewInproceedingsEntryWithEmptyRequiredFieldFailsAndUserIsInformed3() {
        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewInproceedingsEntryWithEmptyRequiredFieldFailsAndUserIsInformed4() {
        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewInproceedingsEntryWithEmptyRequiredFieldFailsAndUserIsInformed5() {
        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "work list", "");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid number entry"));
    }

    @Test
    public void addingANewInproceedingsEntryWithEmptyRequiredFieldsFailsAndUserIsInformed() {
        testIO = new StubIO("inproceedings", "", "", "", "", "");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid number entry"));
    }

    @Test
    public void addingANewInproceedingsEntryWithInvalidPublishYearFailsAndUserIsInformed() {
        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "work list", "invalid");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid number entry"));
    }

    @Test
    public void addingANewEntryWithDuplicateMasterKeyIsHandled() {
        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("inproceedings", "just testing masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("inproceedings", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
        assertTrue(testRefList.get(2).getMasterKey().equals("masterkey__1"));
        assertTrue(testRefList.get(3).getMasterKey().equals("masterkey__2"));
    }

    @Test
    public void addingANewArticleEntry() {
        testIO = new StubIO("article", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
    }

    @Test
    public void addingANewArticleEntryWithEmptyRequiredFieldFailsAndUserIsInformed() {
        testIO = new StubIO("article", null, "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewArticleEntryWithEmptyRequiredFieldFailsAndUserIsInformed2() {
        testIO = new StubIO("article", "masterkey", null, "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewArticleEntryWithEmptyRequiredFieldFailsAndUserIsInformed3() {
        testIO = new StubIO("article", "masterkey", "writerguy", null, "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewArticleEntryWithEmptyRequiredFieldFailsAndUserIsInformed4() {
        testIO = new StubIO("article", "masterkey", "writerguy", "work", null, "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewArticleEntryWithEmptyRequiredFieldFailsAndUserIsInformed5() {
        testIO = new StubIO("article", "masterkey", "writerguy", "work", "work list", "");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid number entry"));
    }

    @Test
    public void addingANewArticleEntryWithDuplicateMasterKeyIsHandled() {
        testIO = new StubIO("article", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("article", "just testing masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("article", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("article", "masterkey", "writerguy", "work", "work list", "2014");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
        assertTrue(testRefList.get(2).getMasterKey().equals("masterkey__1"));
        assertTrue(testRefList.get(3).getMasterKey().equals("masterkey__2"));
    }

    @Test
    public void addingANewBookEntry() {
        testIO = new StubIO("book", "masterkey", "writerguy", "work", "publisher", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
    }

    @Test
    public void addingANewBookEntryWithInvalidInput() {
        testIO = new StubIO("book", "", "writerguy", "work", "publisher", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewBookEntryWithInvalidInput2() {
        testIO = new StubIO("book", "aaafs", "", "work", "publisher", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewBookEntryWithInvalidInput3() {
        testIO = new StubIO("book", "aaafs", "", "work", "publisher", "-1", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewBookEntryWithInvalidInput4() {
        testIO = new StubIO("book", "aaafs", "", "work", "publisher", "hess", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }

    @Test
    public void addingANewBookEntryWithDuplicateMasterKeyIsHandled() {
        testIO = new StubIO("book", "masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("book", "just testing masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("book", "masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        testIO = new StubIO("book", "masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddentry = new Addentry(testIO, testRefList);
        testAddentry.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
        assertTrue(testRefList.get(2).getMasterKey().equals("masterkey__1"));
        assertTrue(testRefList.get(3).getMasterKey().equals("masterkey__2"));
    }
}
