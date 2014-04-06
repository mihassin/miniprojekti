package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author slimy code -esa
 */
public class Bibtex implements Command {

    IO io;
    ArrayList<Inproceedings> refList;

    public Bibtex(IO io, ArrayList<Inproceedings> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        for (Inproceedings inproceedings : refList) {
            io.write(inproceedings.showEntryInBibTeX());
        }
    }

}
