package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author slime-e
 */
public class Print implements Command {

    IO io;
    ArrayList<Inproceedings> refList;

    public Print(IO io, ArrayList<Inproceedings> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        for (Inproceedings inproceedings : refList) {
            io.write(inproceedings.toString());
        }
    }

}
