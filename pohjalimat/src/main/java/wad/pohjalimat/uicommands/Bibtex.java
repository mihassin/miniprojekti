package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Entry;

/**
 *
 * @author slimy code -esa
 */
public class Bibtex implements Command {

    IO io;
    ArrayList<Entry> refList;

    public Bibtex(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        for (Entry inproceedings : refList) {
            io.write(inproceedings.showEntryInBibTeX());
        }
    }

}
