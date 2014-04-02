

package wad.pohjalimat.io;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class ConsoleIO implements IO {
    Scanner in;

    ConsoleIO(Scanner scanner) {
        this.in = scanner;
    }

    @Override
    public String read(String label) {
        System.out.println(label);
        return in.nextLine();
    }

    @Override
    public void write(String data) {
        System.out.println(data);
    }


}
