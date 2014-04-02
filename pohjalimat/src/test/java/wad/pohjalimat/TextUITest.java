/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat;

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.pohjalimat.io.ConsoleIO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author Juhani Heliö
 */
public class TextUITest {
    
    TextUI ui;
    Scanner s;
    
    public TextUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ui=new TextUI();
        s=new Scanner("addentry\nprint\nexit");
        ui.io=new ConsoleIO(s);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test start method with addentry input
     * EI TOIMI VIELÄ
     */
    @Test
    public void testStartAddentry() {
        s=new Scanner("addentryPena\nMuistio\nPenan muistio\n2000");
        ui.io=new ConsoleIO(s);
        ui.start();
        ui.io.read("");
        ui.io.read("");
        ui.io.read("");
        ui.io.read("");
        ui.io.read("");
        assertEquals(ui.refList.get(0), Inproceedings.create("Pena", "Muistio", "Penan muistio", 2000));
    }
    
}
