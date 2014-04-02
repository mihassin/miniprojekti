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
    
    public InproceedingsTest() {
    }

    @Before
    public void setUp() {
        ip=new Inproceedings("Pena", "Muistio", "Penan muistio", 2000);
    }
    
    /**
     * Test of create method, of class Inproceedings.
     */
    @Test
    public void testCreate() {
        assertEquals(ip, Inproceedings.create("Pena", "Muistio", "Penan muistio", 2000));
    }

    /**
     * Test of getAuthor method, of class Inproceedings.
     */
    @Test
    public void testGetAuthor() {
        assertEquals(ip.getAuthor(), "Pena");
    }

    /**
     * Test of getTitle method, of class Inproceedings.
     */
    @Test
    public void testGetTitle() {
        assertEquals(ip.getTitle(), "Muistio");
    }

    /**
     * Test of getBooktitle method, of class Inproceedings.
     */
    @Test
    public void testGetBooktitle() {
        assertEquals(ip.getBooktitle(), "Penan muistio");
    }

    /**
     * Test of getYear method, of class Inproceedings.
     */
    @Test
    public void testGetYear() {
        assertEquals(ip.getYear(), 2000);
    }
    
    
}
