package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Book;
import wad.pohjalimat.model.Entry;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class AddBookTest {

    ArrayList<Entry> testRefList;
    StubIO testIO;
    Book testBook;
    AddBook testAddBook;

    @Before
    public void setUp() {
        testIO = new StubIO();
        testRefList = new ArrayList<Entry>();
        testAddBook = new AddBook(testIO, testRefList);
    }

    @Test
    public void addingANewEntry() {
        testIO = new StubIO("masterkey", "writerguy", "work", "publisher", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();

        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
    }

    @Test
    public void addingANewEntryWithInvalidInput() {
        testIO = new StubIO("", "writerguy", "work", "publisher", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
        @Test
    public void addingANewEntryWithInvalidInput2() {
        testIO = new StubIO("aaafs", "", "work", "publisher", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
        
                @Test
    public void addingANewEntryWithInvalidInput3() {
        testIO = new StubIO("aaafs", "", "work", "publisher", "-1", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
                
                                @Test
    public void addingANewEntryWithInvalidInput4() {
        testIO = new StubIO("aaafs", "", "work", "publisher", "hess", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();

        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
        
            @Test
    public void addingANewEntryWithDuplicateMasterKeyIsHandled () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();
        
        testIO = new StubIO("just testing masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();
        
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();
        
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014", "2", "b", "a", "b", "a", "b", "a");
        testAddBook = new AddBook(testIO, testRefList);
        testAddBook.run();
        
        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
        assertTrue(testRefList.get(2).getMasterKey().equals("masterkey__1"));
        assertTrue(testRefList.get(3).getMasterKey().equals("masterkey__2"));
    }

    private String demLineBreaks() {
        return "\n\n\n\n\n\n\n\n";
    }
}
