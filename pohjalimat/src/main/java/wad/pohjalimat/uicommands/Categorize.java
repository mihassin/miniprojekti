package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Entry;

/**
 *
 * @author e-slime
 */
public class Categorize implements Command {

    IO io;
    ArrayList<Entry> refList;

    public Categorize(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        if (listEntries()) {
            io.write("Select entry number [1-" + refList.size() + "]");
            try {
                int entryNo = Integer.parseInt(io.read("> "));

                if (entryNo < 1 || entryNo > refList.size()) {
                    io.write("");
                    io.write("Illegal entry number");
                } else {
                    io.write("Enter category title");
                    String category = io.read("> ");
                    refList.get(entryNo - 1).setCategory(category);
                }
            } catch (NumberFormatException e) {
                io.write("");
                io.write("Invalid number entry");
            }
        }
    }

    public boolean listEntries() {
        if (refList.isEmpty()) {
            io.write("");
            io.write("There are no entries!");
            return false;
        }
        io.write("");
        io.write("Entries:");
        io.write("");
        for (int i = 0; i < refList.size(); i++) {
            io.write((i + 1) + ") Key: " + refList.get(i).getMasterKey()
                    + ", Author: " + refList.get(i).getAuthor()
                    + ", Title: " + refList.get(i).getTitle());
        }
        io.write("");
        return true;
    }

}
