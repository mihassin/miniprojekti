

package wad.pohjalimat;

import wad.pohjalimat.model.Inproceedings;
import java.util.Scanner;
import wad.pohjalimat.io.ConsoleIO;
import wad.pohjalimat.io.IO;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class TextUI {
    IO io;
    
    public TextUI() {
        io = new ConsoleIO(new Scanner(System.in));
    }

    public void start() {
        io.write("Enter 'addentry' to add an inproceedings bibtex entry");
        io.write("");
        while(!io.read("> ").equals("addentry"));
        Inproceedings inproceedings = new Inproceedings(io.read("author: "),
                io.read("title: "), io.read("booktitle: "), Integer.parseInt(io.read("year: ")));
    }
    

}
