

package wad.pohjalimat.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class ConsoleIOTest {
    IO io;
    Scanner scanner;
    private ByteArrayOutputStream apu=new ByteArrayOutputStream();
    
    public ConsoleIOTest() {
        
    }
    @Before
    public void setUp() {
        scanner = new Scanner("cmd1\ncmd2");
        io = new ConsoleIO(scanner);
        System.setOut(new PrintStream(apu));
    }
    
    @After
    public void clean(){
        System.setOut(null);
    }
    
    @Test
    public void readReturnsCorrectString() {
        assertEquals("cmd1",io.read(""));
    }
    
    @Test
    public void readReturnsCorrectString2() {
        io.read("");
        assertEquals("cmd2",io.read(""));
    }
    
    //Vähän kesken viel, antaa failure
    @Test
    public void writeWritesTheCorrectString(){
        io.write("");
        assertEquals("", apu.toString());
    }
    
    // Eivät toimi
//    @Test
//    public void readShowsCorrectLabel() {
//        io.read("label");
//        String result = byteArrayToString(output.toByteArray());
//        assertEquals("label", result);
//
//    }
//
//    private String byteArrayToString(byte[] bytes) {
//        String result = "";
//        for (int i = 0; i < bytes.length; i++) {
//            System.out.println(bytes[i]);
//            result += bytes[i];
//        }
//        return result;
//    }





}