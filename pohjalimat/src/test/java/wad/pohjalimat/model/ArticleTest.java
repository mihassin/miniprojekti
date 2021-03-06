/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.pohjalimat.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vesihiisi
 */
public class ArticleTest {

    Article a;

    @Before
    public void setUp() {
        a = new Article("a1", "test1", "test1", "test1", 2000);
    }

    /**
     * Test of create method, of class Article.
     */
    @Test
    public void testSetjaGetJournal() {
        a.setJournal("test2");
        assertEquals("test2", a.getJournal());
    }

    /**
     * Test of getNumber method, of class Article.
     */
    @Test
    public void testSetJaGetNumber() {
        a.setNumber(1);
        assertEquals(1, a.getNumber());
    }

    /**
     * Test of getAuthor method, of class Article.
     */
    @Test
    public void testSetJaGetAuthor() {
        a.setAuthor("test2");
        assertEquals("test2", a.getAuthor());
    }

    /**
     * Test of getYear method, of class Article.
     */
    @Test
    public void testSetJaGetYear() {
        a.setYear(2001);
        assertEquals(2001, a.getYear());
    }

    /**
     * Test of getVolume method, of class Article.
     */
    @Test
    public void testSetJaGetVolume() {
        a.setVolume(1);
        assertEquals(1, a.getVolume());
    }

    /**
     * Test of getMonth method, of class Article.
     */
    @Test
    public void testSetJaGetMonth() {
        a.setMonth("test2");
        assertEquals("test2", a.getMonth());
    }

    /**
     * Test of getMonthNumeric method, of class Article.
     */
    @Test
    public void testSetJaGetMonthNumeric() {
        a.setMonthNumeric(1);
        assertEquals(1, a.getMonthNumeric());
    }

    @Test
    public void testSetJaGetMonthNumericNegatiivisella() {
        a.setMonthNumeric(-1);
        assertEquals(0, a.getMonthNumeric());
    }

    @Test
    public void testSetJaGetMonthNumericYliKaksitoista() {
        a.setMonthNumeric(13);
        assertEquals(12, a.getMonthNumeric());
    }

    /**
     * Test of getNote method, of class Article.
     */
    @Test
    public void testSetJaGetNote() {
        a.setNote("test2");
        assertEquals("test2", a.getNote());
    }

    /**
     * Test of getKey method, of class Article.
     */
    @Test
    public void testSetJaGetMesterKey() {
        a.setMasterKey("b2");
        assertEquals("b2", a.getMasterKey());
    }

    /**
     * Test of getPages method, of class Article.
     */
    @Test
    public void testSetJaGetPages() {
        a.setPages("{200-300}");
        assertEquals("{200-300}", a.getPages());
    }

    @Test
    public void testSetJaGetTitle() {
        a.setTitle("test1");
        assertEquals("test1", a.getTitle());
    }

    /**
     * Test of toString method, of class Article.
     */
    @Test
    public void testToString() {
        dummyarvot();
        String apu = "*** test2 ***\n"
                + "Author: test2\n"
                + "Journal: test2\n"
                + "Year: 2001\n"
                + "Number: 1\n"
                + "Pages: {200-300}\n"
                + "Month: test2\n"
                + "Note: test2\n"
                + "Volume: 1\n";
        assertEquals(apu, a.toString());

    }

    @Test
    public void testToStringPieni() {
        dummyarvotPieni();
        String apu = "*** test2 ***\n"
                + "Author: test2\n"
                + "Journal: test2\n"
                + "Year: 2001\n";
        assertEquals(apu, a.toString());
    }

    /**
     * Test of showEntryInBibTeX method, of class Article.
     */
    @Test
    public void testShowEntryInBibTeX() {
        dummyarvot();
        a.setMonthNumeric(1);
        String apu = "@ARTICLE{b2,\n"
                + "author = \"test2\",\n"
                + "title = \"test2\",\n"
                + "journal = \"test2\",\n"
                + "year = \"2001\",\n"
                + "number = \"1\",\n"
                + "pages = \"{200-300}\",\n"
                + "month = \"1\",\n"
                + "note = \"test2\",\n"
                + "volume = \"1\",\n"
                + "}";
        assertEquals(apu, a.showEntryInBibTeX());
    }

    @Test
    public void testShowEntryInBibTeXPieni() {
        dummyarvotPieni();
        String apu = "@ARTICLE{b2,\n"
                + "author = \"test2\",\n"
                + "title = \"test2\",\n"
                + "journal = \"test2\",\n"
                + "year = \"2001\","
                + "\n}";
        assertEquals(apu, a.showEntryInBibTeX());
    }

    private void dummyarvot() {
        a.setMasterKey("b2");
        a.setAuthor("test2");
        a.setTitle("test2");
        a.setJournal("test2");
        a.setYear(2001);
        a.setNumber(1);
        a.setPages("{200-300}");
        a.setMonth("test2");
        a.setNote("test2");
        a.setVolume(1);
    }

    private void dummyarvotPieni() {
        a.setMasterKey("b2");
        a.setAuthor("test2");
        a.setTitle("test2");
        a.setJournal("test2");
        a.setYear(2001);
        a.setNumber(-10000);
        a.setPages(null);
        a.setMonth(null);
        a.setNote(null);
        a.setVolume(-100000);
    }

    /**
     * Test of hashCode method, of class Article.
     */
    @Test
    public void testHashCode() {
        assertEquals(a.hashCode(), a.hashCode());
    }

    /**
     * Test of equals method, of class Article.
     */
    @Test
    public void testEquals() {
        Article b = Article.create("a1", "test1", "test1", "test1", 2000);
        assertEquals(b, a);
    }

    @Test
    public void wontEqNull() {
        assertFalse(a.equals(null));
    }

    @Test
    public void wontEqWithSomethingThatItsNot() {
        assertFalse(a.equals(Object.class));
    }

//    @Test
//    public void wontEqWithFalseNumber() {
//        Article b = new Article("key", "marko", "otsikko", "journal", 1234);
//        a.setNumber(1);
//        b.setNumber(2);
//        assertFalse(a.equals(b));
//    }
    @Test
    public void wontEqWithFalseJurnalli() {
        Article b = Article.create("a1", "test1", "test1", "test1", 2000);
        b.setJournal("moi");
        assertFalse(a.equals(b));
    }

    @Test
    public void wontEqWithFalseYear() {
        Article b = Article.create("a1", "test1", "test1", "test1", 2001);
        assertFalse(a.equals(b));
    }

    @Test
    public void wontEqWithFalseKey() {
        Article b = Article.create("a2", "test1", "test1", "test1", 2000);
        assertFalse(a.equals(b));
    }

    @Test
    public void wontEqWithFalseAuthor() {
        Article b = Article.create("a1", "test1a", "test1", "test1", 2000);
        assertFalse(a.equals(b));
    }

    @Test
    public void wontEqWithFalseTitle() {
        Article b = Article.create("a1", "test1", "testaa", "test1", 2000);
        assertFalse(a.equals(b));
    }

    // Illegal argument testings
    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidMasterKey() {
        Article.create("", "Make", "IP conffaus", "Unigrafia", 2014);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidAuthor() {
        Article.create("viite2", "", "IP conffaus", "Unigrafia", 2014);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidTitle() {
        Article.create("viite2", "a", "", "Unigrafia", 2014);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionIfInvalidPublisher() {
        Article.create("viite2", "a", "b", "", 2014);
    }

    // setmonthnumeric penistelytesti
    @Test
    public void setMonthNumericPaskastiKaytettynaEiKaadaOhjelmaa() {
        Article b = Article.create("viite2", "a", "b", "jussi", 2014);
        b.month = "kekkilän puutarhamulta";
        assertEquals(0, b.getMonthNumeric());
    }
}
