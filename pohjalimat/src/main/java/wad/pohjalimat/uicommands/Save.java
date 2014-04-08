package wad.pohjalimat.uicommands;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author slimy code -esa
 */
public class Save implements Command {

    PrintWriter writer;
    IO io;
    ArrayList<Inproceedings> refList;

    public Save(IO io, ArrayList<Inproceedings> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        String fileName = io.read("File name (automatic .bib extension): ");
        try {
            this.writer = new PrintWriter(fileName + ".bib");
        } catch (FileNotFoundException ex) {
            io.write("error with .bib creation");
        }
        for (Inproceedings inproceedings : refList) {
            writer.println(inproceedings.showEntryInBibTeX());
        }
        writer.close();
        io.write("Saved to " + fileName + ".bib");
    }

}
