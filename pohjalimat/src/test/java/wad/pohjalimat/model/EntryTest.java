package wad.pohjalimat.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class EntryTest {
    
    Entry e;
    
    public EntryTest() {
        e = new Article("a", "a", "a", "a", 1234);
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
}
