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
    
    public InproceedingsTest() {
    }

    @Before
    public void setUp() {
        ip=new Inproceedings("viite1","Pena", "Muistio", "Penan muistio", 2000);
        mouckaPhii = Inproceedings.create("viite1","Pena", "Muistio", "Penan muistio", 2000);
    }
    
    /**
     * Test of create method, of class Inproceedings.
     */
    @Test
    public void testCreate() {
        assertEquals(ip, Inproceedings.create("Viite1","Pena", "Muistio", "Penan muistio", 2000));
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        assertEquals( "Pena", ip.getAuthor() ); //slime-marko
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        assertEquals( "Muistio", ip.getTitle() ); // slime-make
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        
        assertEquals( "Penan muistio", ip.getBooktitle() ); //slime-kake
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        
        assertEquals( 2000, ip.getYear() ); //slimeM
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
}
