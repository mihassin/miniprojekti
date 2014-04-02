

package wad.pohjalimat.io;

import java.io.PrintWriter;
import java.util.Scanner;
import wad.pohjalimat.model.Model;

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

    @Override
    public void printHumanReadableModel(Model model) {
        System.out.println("*** " + model.getTitle() + " ***" + "\n" +
                           "Author: " + model.getAuthor() + "\n" +
                           "Book title: " + model.getBooktitle() + "\n" +
                           "Year published: " + model.getYear() + "\n");
    }


}
