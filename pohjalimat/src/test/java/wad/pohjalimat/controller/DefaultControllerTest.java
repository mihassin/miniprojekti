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
public class DefaultControllerTest {
    
    private Model m;
    DefaultController instance;
    
    public DefaultControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        instance = new DefaultController();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of handleDefault method, of class DefaultController.
     */
    @Test
    public void testHandleDefault() {
        String expResult = "prompt";
        String result = instance.handleDefault();
        assertEquals(expResult, result);
    }
    
}
