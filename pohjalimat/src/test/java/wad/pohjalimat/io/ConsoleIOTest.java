

package wad.pohjalimat.io;

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
        scanner = new Scanner("cmd1\ncmd2");
        io = new ConsoleIO(scanner);
    }



    @Before
    public void setUp() {
    }





}