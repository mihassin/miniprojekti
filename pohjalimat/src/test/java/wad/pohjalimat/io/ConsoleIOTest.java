

package wad.pohjalimat.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class ConsoleIOTest {
    IO io;
    Scanner scanner;

    public ConsoleIOTest() {
        
    }
    @Before
    public void setUp() {
        scanner = new Scanner("cmd1\ncmd2");
        io = new ConsoleIO(scanner);
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