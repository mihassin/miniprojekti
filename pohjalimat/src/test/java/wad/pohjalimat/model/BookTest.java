package wad.pohjalimat.model;

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
public class BookTest {

    Book book;
    Book book2;

    @Before
    public void setUp() {
        book = new Book("viite2", "Make", "IP conffaus", "Unigrafia", 2014);
        book2 = Book.create("viite2", "Make", "IP conffaus", "Unigrafia", 2014);
    }

    @Test
    public void createWorks() {
        assertEquals(book, Book.create("viite2", "Make", "IP conffaus", "Unigrafia", 2014));
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidMasterKey() {
        Book.create("", "Make", "IP conffaus", "Unigrafia", 2014);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidAuthor() {
        Book.create("viite2", "", "IP conffaus", "Unigrafia", 2014);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidTitle() {
        Book.create("viite2", "a", "", "Unigrafia", 2014);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidPublisher() {
        Book.create("viite2", "a", "b", "", 2014);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidYear() {
        Book.create("viite2", "a", "b", "c", -1);
    }

    @Test
    public void getNSetMasterKey() {
        assertEquals("viite2", book2.getMasterKey());

        book2.setMasterKey("viite3");
        assertEquals("viite3", book2.getMasterKey());
    }

    @Test
    public void getNSetAuthor() {
        assertEquals("Make", book2.getAuthor());

        String newValue = "Viljami";
        book2.setAuthor(newValue);
        assertEquals(newValue, book2.getAuthor());
    }

    @Test
    public void getNSetTitle() {
        assertEquals("IP conffaus", book2.getTitle());

        String newValue = "hese";
        book2.setTitle(newValue);
        assertEquals(newValue, book2.getTitle());
    }

    @Test
    public void getNSetPublisher() {
        assertEquals("Unigrafia", book2.getPublisher());

        String newValue = "Jeesus";
        book2.setPublisher(newValue);
        assertEquals(newValue, book2.getPublisher());
    }

    @Test
    public void getNSetYear() {
        assertEquals(2014, book2.getYear());

        int newValue = 1992;
        book2.setYear(newValue);
        assertEquals(newValue, book2.getYear());
    }

    // volume/number, series, address, edition, month, note, key
    @Test
    public void getNSetVolume() {
        int newValue = 1;
        book2.setVolume(newValue);
        assertEquals(newValue, book2.getVolume());
    }

    @Test
    public void getNSetSeries() {
        String newValue = "ker";
        book2.setSeries(newValue);
        assertEquals(newValue, book2.getSeries());
    }

    @Test
    public void getNSetAddress() {
        String newValue = "ker";
        book2.setAddress(newValue);
        assertEquals(newValue, book2.getAddress());
    }

    @Test
    public void getNSetEdition() {
        String newValue = "ker";
        book2.setEdition(newValue);
        assertEquals(newValue, book2.getEdition());
    }

    @Test
    public void getNSetMonth() {
        String newValue = "ker";
        book2.setMonth(newValue);
        assertEquals(newValue, book2.getMonth());
    }

    @Test
    public void getNSetNote() {
        String newValue = "ker";
        book2.setNote(newValue);
        assertEquals(newValue, book2.getNote());
    }

    @Test
    public void getNSetKey() {
        String newValue = "ker";
        book2.setKey(newValue);
        assertEquals(newValue, book2.getKey());
    }

    @Test
    public void EqualFailsWithDiffYear() {
        assertFalse(book2.equals(new Book("viite2", "Make", "IP conffaus", "Unigrafia", 2012)));
    }

    @Test
    public void EqualFailsWithDiffPublisher() {
        assertFalse(book2.equals(new Book("viite2", "Make", "IP conffaus", "Unigrafiii", 2014)));
    }

    @Test
    public void EqualFailsWithDiffTitle() {
        assertFalse(book2.equals(new Book("viite2", "Make", "IP conffau", "Unigrafia", 2014)));
    }

    @Test
    public void EqualFailsWithDiffAuthor() {
        assertFalse(book2.equals(new Book("viite2", "Maske", "IP conffaus", "Unigrafia", 2014)));
    }

    @Test
    public void EqualFailsWithDiffMasterKey() {
        assertFalse(book2.equals(new Book("viite383", "Maske", "IP conffaus", "Unigrafia", 2014)));
    }
    
    @Test
    public void EqualFailsWithNullClass() {
        assertFalse(book2.equals(null));
    }
    @Test
    public void EqualFailsWithDiffClass() {
        assertFalse(book2.equals(new Inproceedings("a", "b", "c", "dsa", 3456)));
    }
    

    @Test
    public void EqualSucceedsWithSameBooks() {
        assertTrue(book2.equals(book));
    }

    @Test
    public void hashCodeDiffForDiffBooks() {
        assertNotSame(book2.hashCode(), new Book("viite383", "Maske", "IP conffaus", "Unigrafia", 2014).hashCode());
    }

    @Test
    public void hashCodeDiffForDiffBooks2() {
        assertNotSame(book2.hashCode(), new Book("viite2", "Maske", "IP conffaus", "Unigrafia", 2012).hashCode());
    }
}