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
 * @author Juhani Heliö
 */
public class InproceedingsTest {

    Inproceedings ip;
    Inproceedings mouckaPhii;
    Inproceedings elGiganto;

    public InproceedingsTest() {
    }

    @Before
    public void setUp() {
        ip = new Inproceedings("viite1", "Pena", "Muistio", "Penan muistio", 2000);
        mouckaPhii = Inproceedings.create("viite1", "Pena", "Muistio", "Penan muistio", 2000);
        elGiganto = Inproceedings.create("giganto1", "Senor Gigante", "El Giganto", "Suuri mies hän on", 2014);
        elGiganto.setEditor("testeditor");
        elGiganto.setVolume(9999);
        elGiganto.setSeries("testseries");
        elGiganto.setPages("10--20");
        elGiganto.setAddress("testaddress");
        elGiganto.setMonth("January");
        elGiganto.setPublisher("testpublisher");
        elGiganto.setOrganisation("testorganisation");
        elGiganto.setNote("testnote");
        elGiganto.setKey("testkey");

    }

    /**
     * Test of create method, of class Inproceedings.
     */
    @Test
    public void testCreate() {
        assertEquals(ip, Inproceedings.create("viite1", "Pena", "Muistio", "Penan muistio", 2000));
    }

    @Test
    public void testGetMasterkey() {
        assertEquals("viite1", ip.getMasterKey());
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        assertEquals("Pena", ip.getAuthor()); //slime-marko
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Muistio", ip.getTitle()); // slime-make
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {

        assertEquals("Penan muistio", ip.getBooktitle()); //slime-kake
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {

        assertEquals(2000, ip.getYear()); //slimeM
    }

    @Test
    public void testGetEditor() {

        assertEquals("testeditor", elGiganto.getEditor());
    }

    @Test
    public void testGetVolume() {

        assertEquals(9999, elGiganto.getVolume());
    }

    @Test
    public void testGetSeries() {

        assertEquals("testseries", elGiganto.getSeries());
    }

    @Test
    public void testGetPages() {

        assertEquals("10--20", elGiganto.getPages());
    }

    @Test
    public void testGetAddress() {

        assertEquals("testaddress", elGiganto.getAddress());
    }

    @Test
    public void testGetMonth() {

        assertEquals("January", elGiganto.getMonth());
    }

    @Test
    public void testGetPublisher() {

        assertEquals("testpublisher", elGiganto.getPublisher());
    }

    @Test
    public void testGetOrganisation() {

        assertEquals("testorganisation", elGiganto.getOrganisation());
    }

    @Test
    public void testGetNote() {

        assertEquals("testnote", elGiganto.getNote());
    }

    @Test
    public void testGetKey() {

        assertEquals("testkey", elGiganto.getKey());
    }

    /* slimy-marko */
    @Test
    public void equalsMethodObjNull() {
        assertFalse(ip.equals(null));
    }

    @Test
    public void selfEqTrueOFC() {
        assertTrue(ip.equals(ip));
    }

    @Test
    public void wiffMockClassTru() {
        assertTrue(ip.equals(mouckaPhii));
    }

    @Test
    public void wiffMockClassSetNewAuth() {
        mouckaPhii.setAuthor("slime");
        assertFalse(ip.equals(mouckaPhii));
    }

    @Test
    public void wiffMockClassSetNewTitle() {
        mouckaPhii.setTitle("slime");
        assertFalse(ip.equals(mouckaPhii));
    }

    @Test
    public void wiffMockClassSetNewBookTitle() {
        mouckaPhii.setBooktitle("slime");
        assertFalse(ip.equals(mouckaPhii));
    }

    @Test
    public void wiffMockClassSetNewYarr() {
        mouckaPhii.setYear(1234);
        assertFalse(ip.equals(mouckaPhii));
    }

    @Test
    public void stringgingInprocedding() {
        assertFalse(ip.equals(123));
    }

    @Test
    public void gettinNSettinAuth() {
        ip.setAuthor("slime");

        assertEquals("slime", ip.getAuthor());
    }

    @Test
    public void gettinNSettinTitle() {
        ip.setTitle("slime");

        assertEquals("slime", ip.getTitle());
    }

    @Test
    public void gettinNSettinBookTitle() {
        ip.setBooktitle("slime");

        assertEquals("slime", ip.getBooktitle());
    }

    @Test
    public void gettinNSettinYARR() {
        ip.setYear(1234);

        assertEquals(1234, ip.getYear());
    }

    @Test
    public void freshHash() {
        int hashh = ip.hashCode();

        assertEquals(hashh, ip.hashCode());
    }

    @Test
    public void unFreshHash() {
        assertNotSame(ip.hashCode(), mouckaPhii.hashCode());
    }

    @Test
    public void testToString() {
        String testString = "*** Muistio ***\nAuthor: Pena\n"
                + "Book title: Penan muistio\n"
                + "Year: 2000\n";

        assertEquals(testString, ip.toString());
    }

    @Test
    public void testLongToString() {
        String testString = "*** El Giganto ***\nAuthor: Senor Gigante\n"
                + "Book title: Suuri mies hän on\n"
                + "Year: 2014\n"
                + "Editor: testeditor\n"
                + "Volume: 9999\n"
                + "Series: testseries\n"
                + "Pages: 10--20\n"
                + "Address: testaddress\n"
                + "Month: January\n"
                + "Publisher: testpublisher\n"
                + "Organisation: testorganisation\n"
                + "Note: testnote\n"
                + "Key: testkey\n";

        assertEquals(testString, elGiganto.toString());
    }
    
    @Test
    public void testShowEntryInBibtex() {
        String testString = "@INPROCEEDINGS{viite1,\n"
                + "author = \"Pena\",\n"
                + "title = \"Muistio\",\n"
                + "booktitle = \"Penan muistio\",\n"
                + "year = \"2000\",\n"
                + "}";

        assertEquals(testString, ip.showEntryInBibTeX());
    }
    
    @Test
    public void testLongShowEntryInBibtex() {
        String testString = "@INPROCEEDINGS{giganto1,\n"
		+ "author = \"Senor Gigante\",\n"
                + "title = \"El Giganto\",\n"
                + "booktitle = \"Suuri mies h\\\"{a}n on\",\n"
                + "year = \"2014\",\n"
                + "editor = \"testeditor\",\n"
                + "volume = \"9999\",\n"
                + "series = \"testseries\",\n"
                + "pages = \"10--20\",\n"
                + "address = \"testaddress\",\n"
                + "month = \"January\",\n"
                + "publisher = \"testpublisher\",\n"
                + "organisation = \"testorganisation\",\n"
                + "note = \"testnote\",\n"
                + "key = \"testkey\",\n"
                + "}";

        assertEquals(testString, elGiganto.showEntryInBibTeX());
    }

}
