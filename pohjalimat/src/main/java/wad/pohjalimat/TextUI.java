

package wad.pohjalimat;

import java.util.ArrayList;
import java.util.Scanner;
import wad.pohjalimat.io.ConsoleIO;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class TextUI {
    IO io;
    ArrayList<Inproceedings> refList;
    
    public TextUI() {
        io = new ConsoleIO(new Scanner(System.in));
        refList = new ArrayList<Inproceedings>();
    }

    public void start() {
        io.write("");
        io.write("Enter 'addentry' to add an inproceedings BibTex entry");
        io.write("Enter 'print' to print a list of added content");
        io.write("Enter 'exit' to quit the program");
        io.write("");
        
        String command = io.read("> ");
        
        if (command.equals("addentry")) {
            refList.add(Inproceedings.create(
                io.read("author: "),
                io.read("title: "),
                io.read("booktitle: "),
                Integer.parseInt(io.read("year: "))));
        } else if (command.equals("print")) {
            for (Inproceedings inproceedings : refList) {
                io.printHumanReadableInproceedings(inproceedings);
            }
        }
        
        if (!command.equals("exit")) {
            start();
        }
    }
}
