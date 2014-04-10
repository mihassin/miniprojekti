package wad.pohjalimat.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class EntryTest {
    
    Entry e;
    
    public EntryTest() {
        e = new Article("a", "a", "a", "a", 1234);
    }
    
    @Test(expected=NullPointerException.class)
    public void editorToStringTest() {
        assertEquals("", e.EditorToString());
    }
    
    @Test
    public void volumeToStringTest() {
        assertEquals("Volume: "+e.volume+ "\n", e.VolumeToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void seriesToStringTest() {
        assertEquals("", e.SeriesToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void pagesToStringTest() {
        assertEquals("", e.PagesToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void addressToStringTest() {
        assertEquals("", e.AddressToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void monthToStringTest() {
        assertEquals("", e.MonthToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void publisherToStringTest() {
        assertEquals("", e.PublisherToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void organisationToStringTest() {
        assertEquals("", e.OrganisationToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void noteToStringTest() {
        assertEquals("", e.NoteToString());
    }
    
    @Test(expected=NullPointerException.class)
    public void keyToStringTest() {
        assertEquals("Key: "+ e.key+ "\n", e.KeyToString());
    }
}
