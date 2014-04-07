package wad.pohjalimat.io;

import java.util.Scanner;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class ConsoleIO implements IO {
    Scanner in;

    public ConsoleIO(Scanner scanner) {
        this.in = scanner;
    }

    @Override
    public String read(String label) {
        System.out.print(label);
        return in.nextLine();
    }

    @Override
    public void write(String data) {
        System.out.println(data);
    }

}
