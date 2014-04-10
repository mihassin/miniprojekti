package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Entry;

/**
 *
 * @author slime-e
 */
public class Print implements Command {

    IO io;
    ArrayList<Entry> refList;

    public Print(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        for (Entry inproceedings : refList) {
            io.write(inproceedings.toString());
        }
    }

}
