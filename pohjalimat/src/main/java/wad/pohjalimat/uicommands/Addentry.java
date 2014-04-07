package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author lima-esa
 */
public class Addentry implements Command {

    IO io;
    ArrayList<Inproceedings> refList;

    public Addentry(IO io, ArrayList<Inproceedings> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        try {
            try {
                refList.add(Inproceedings.create(
                        io.read("Reference key: "),
                        io.read("author: "),
                        io.read("title: "),
                        io.read("booktitle: "),
                        Integer.parseInt(io.read("year: "))));
            } catch (NullPointerException e) {
                io.write("");
                io.write("Invalid entry");
            }
        } catch (NumberFormatException e) {
            io.write("");
            io.write("Invalid entry");
        }
    }
}
