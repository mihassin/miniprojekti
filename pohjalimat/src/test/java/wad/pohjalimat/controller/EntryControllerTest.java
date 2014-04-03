/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.controller;

import java.util.Collection;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.Model;

/**
 *
 * @author Juhani Heliö
 */
public class EntryControllerTest {
    EntryController instance;
    Model m;
    public EntryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance = new EntryController();
        m=new Model() {

            @Override
            public Model addAttribute(String string, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> clctn) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String string) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of list method, of class EntryController.
     */
    @Test
    public void testList() {
        String expResult = "entries";
        String result = instance.list(m);
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntry method, of class EntryController.
     */
    @Test
    public void testAddEntry() {
        String expResult = "entry";
        String result = instance.addEntry(m);
        assertEquals(expResult, result);
    }
    
}
