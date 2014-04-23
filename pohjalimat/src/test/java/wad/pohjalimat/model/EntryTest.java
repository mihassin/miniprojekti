package wad.pohjalimat.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class EntryTest {
    
    Entry e;
    Entry dummy;
    
    public EntryTest() {
        e = new Article("a", "a", "a", "a", 1234);
        dummy = new EntryDummy();
    }
    
    @Test
    public void editorToStringTest() {
        assertEquals("", e.EditorToString());
    }
    
    @Test
    public void volumeToStringTest() {
        assertEquals("", e.VolumeToString());
    }
    
    @Test
    public void seriesToStringTest() {
        assertEquals("", e.SeriesToString());
    }
    
    @Test
    public void pagesToStringTest() {
        assertEquals("", e.PagesToString());
    }
    
    @Test
    public void addressToStringTest() {
        assertEquals("", e.AddressToString());
    }
    
    @Test
    public void monthToStringTest() {
        assertEquals("", e.MonthToString());
    }
    
    @Test
    public void publisherToStringTest() {
        assertEquals("", e.PublisherToString());
    }
    
    @Test
    public void organisationToStringTest() {
        assertEquals("", e.OrganisationToString());
    }
    
    @Test
    public void noteToStringTest() {
        assertEquals("", e.NoteToString());
    }
    
    @Test
    public void keyToStringTest() {
        assertEquals("", e.KeyToString());
    }
    
    @Test
    public void titleToStringTest() {
        assertEquals("Title: a\n", e.TitleToString());
    }
    
    @Test
    public void getNSetCategoryTest() {
        assertNull(dummy.getCategory());
        dummy.setCategory("kirja");
        assertEquals("kirja", dummy.getCategory());
    }
}

class EntryDummy extends Entry {

    @Override
    public String toString() {
        return "";
    }

    @Override
    public String showEntryInBibTeX() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
    
}

