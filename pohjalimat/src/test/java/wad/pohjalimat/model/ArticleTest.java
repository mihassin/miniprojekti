
package wad.pohjalimat.model;

import org.junit.*;
import static org.junit.Assert.*;

public class ArticleTest {
    
    Article a;
    
    public ArticleTest() {
        a = new Article("key", "marko", "otsikko", "journal", 1234);
    }
    
    @Test
    public void testCreate() {
        assertEquals(a, Article.create("key", "marko", "otsikko", "journal", 1234));
    }
    
    @Test
    public void getNSetJournal() {
        a.setJournal("uusi");
        assertEquals("uusi", a.getJournal());
    }
    
    @Test
    public void getNSetNumber() {
        a.setNumber(123);
        assertEquals(123, a.getNumber());
    }
    
    @Test
    public void getNSetAuthor() {
        a.setAuthor("Juhkuboo");
        assertEquals("Juhkuboo", a.getAuthor());
    }
    
    @Test
    public void getNSetYear() {
        a.setYear(4321);
        assertEquals(4321, a.getYear());
    }
    
    @Test
    public void getNSetVolume() {
        a.setVolume(4321);
        assertEquals(4321, a.getVolume());
    }
    
    @Test
    public void getNSetMonth() {
        a.setMonth("may");
        assertEquals("may", a.getMonth());
    }
    
    @Test
    public void getNSetNote() {
        a.setNote("may");
        assertEquals("may", a.getNote());
    }
    
    @Test
    public void getNSetKey() {
        a.setKey("may");
        assertEquals("may", a.getKey());
    }
    
    @Test
    public void getNSetPages() {
        a.setPages("may");
        assertEquals("may", a.getPages());
    }
    
    @Test
    public void getNSetBooktitle() {
        a.setBooktitle("may");
        assertEquals("may", a.getBooktitle());
    }
    
    //todo
    @Test
    public void articleToString() {
    }
    
    @Test
    public void printBibtext() {
    }
}
