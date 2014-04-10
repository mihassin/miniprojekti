/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat;

import java.util.Scanner;
import org.junit.*;
import static org.junit.Assert.*;
import wad.pohjalimat.io.*;
import wad.pohjalimat.uicommands.CommandStash;
import org.mockito.Mockito.*;

/**
 *
 * @author Juhani Heliö, lima-marko contributed
 */
public class TextUITest {
    
    TextUI tu;
    CommandStash commands;
    
    public TextUITest() {
    }
    
    @Test
    public void testStart() {
    }
    
    @Test
    public void testCommandStash() { //slime-marko
        ConsoleIO io = new ConsoleIO(new Scanner(System.in));
        tu = new TextUI(io);
        commands = tu.getCommandStash();
        
        assertEquals(commands, tu.getCommandStash());
    }
    
}
