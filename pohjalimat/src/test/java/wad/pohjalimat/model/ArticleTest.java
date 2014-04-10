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
        a=new Article("a1","test1", "test1", "test1", 2000);
    }
    
    /**
     * Test of create method, of class Article.
     */
    @Test
    public void testCreate() {
        Article b=Article.create("a1", "test1", "test1", "test1", 2000);
        assertEquals(b, a);
    }

    /**
     * Test of getJournal method, of class Article.
     */
    @Test
    public void testSetjaGetJournal() {
        a.setJournal("test2");
        assertEquals(a.getJournal(), "test2");
    }

    /**
     * Test of getNumber method, of class Article.
     */
    @Test
    public void testSetJaGetNumber() {
        a.setNumber(1);
        assertEquals(a.getNumber(), 1);
    }

    /**
     * Test of getAuthor method, of class Article.
     */
    @Test
    public void testSetJaGetAuthor() {
        a.setAuthor("test2");
        assertEquals(a.getAuthor(), "test2");
    }

    /**
     * Test of getYear method, of class Article.
     */
    @Test
    public void testSetJaGetYear() {
        a.setYear(2001);
        assertEquals(a.getYear(), 2001);
    }

    /**
     * Test of getVolume method, of class Article.
     */
    @Test
    public void testSetJaGetVolume() {
        a.setVolume(1);
        assertEquals(a.getVolume(), 1);
    }

    /**
     * Test of getMonth method, of class Article.
     */
    @Test
    public void testSetJaGetMonth() {
        a.setMonth("test2");
        assertEquals(a.getMonth(), "test2");
    }

    /**
     * Test of getMonthNumeric method, of class Article.
     */
    @Test
    public void testSetJaGetMonthNumeric() {
        a.setMonthNumeric(1);
        assertEquals(a.getMonthNumeric(), 1);
    }
    
    @Test
    public void testSetJaGetMonthNumericNegatiivisella() {
        a.setMonthNumeric(-1);
        assertEquals(a.getMonthNumeric(), 0);
    }
    
    @Test
    public void testSetJaGetMonthNumericYliKaksitoista() {
        a.setMonthNumeric(13);
        assertEquals(a.getMonthNumeric(), 12);
    }

    /**
     * Test of getNote method, of class Article.
     */
    @Test
    public void testSetJaGetNote() {
        a.setNote("test2");
        assertEquals(a.getNote(), "test2");
    }

    /**
     * Test of getKey method, of class Article.
     */
    @Test
    public void testSetJaGetMesterKey() {
        a.setMasterKey("b2");
        assertEquals(a.getMasterKey(), "b2");
    }

    /**
     * Test of getPages method, of class Article.
     */
    @Test
    public void testSetJaGetPages() {
        a.setPages("{200-300}");
        assertEquals(a.getPages(), "{200-300}");
    }
    
    @Test
    public void testSetJaGetTitle() {
        a.setTitle("test1");
        assertEquals(a.getTitle(), "test1");
    }

    /**
     * Test of toString method, of class Article.
     */
    @Test
    public void testToString() {
        dummyarvot();
        String apu="*** test2 ***\n"
                + "Author: test2\n"
                + "Journal: test2\n"
                + "Year published: 2001\n"
                + "Number: 1\n"
                + "Pages: {200-300}\n"
                + "Month: test2\n"
                + "Note: test2\n"
                + "Volume: 1\n";
        assertEquals(a.toString(), apu);
        
    }

    /**
     * Test of showEntryInBibTeX method, of class Article.
     */
    @Test
    public void testShowEntryInBibTeX() {
        dummyarvot();
        a.setMonthNumeric(1);
        String apu="@ARTICLE{b2,\n"
                + "author = \"test2\",\n"
                + "title = \"test2\",\n"
                + "journal = \"test2\",\n"
                + "year = 2001,\n"
                + "number = 1,\n"
                + "pages = \"{200-300}\",\n"
                + "month = 1,\n"
                + "note = \"test2\",\n"
                + "volume = 1\n"
                + "}";
        assertEquals(a.showEntryInBibTeX(), apu);
    }

    private void dummyarvot(){
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
        Article b=Article.create("a1", "test1", "test1", "test1", 2000);
        assertEquals(a, b);
    }
    
}
