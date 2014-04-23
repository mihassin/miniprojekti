package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Entry;

/**
 *
 * @author slim-e
 */
public class Search implements Command {

    IO io;
    ArrayList<Entry> refList;
    ArrayList<String> catList;

    public Search(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
        this.catList = new ArrayList<String>();
    }

    @Override
    public void run() {
        if (listCategories()) {
            try {
                io.write("Select category number [1-" + catList.size() + "]");
                int catNo = Integer.parseInt(io.read("> "));
                if (catNo < 1 || catNo > catList.size()) {
                    io.write("Illegal category number");
                } else {
                    listEntriesWithCategory(catList.get(catNo - 1));
                }
            } catch (NumberFormatException e) {
                io.write("");
                io.write("Invalid number entry");
            }
        }
    }

    public boolean listCategories() {
        for (Entry e : refList) {
            if (e.getCategory() != null) {
                if (!catList.contains(e.getCategory())) {
                    catList.add(e.getCategory());
                }
            }
        }
        if (catList.isEmpty()) {
            io.write("");
            io.write("There are no added categories");
            return false;
        }
        io.write("");
        io.write("Categories:");
        for (int i = 0; i < catList.size(); i++) {
            io.write((i + 1) + ") " + catList.get(i));
        }
        return true;
    }

    private void listEntriesWithCategory(String category) {
        io.write("");
        io.write("Entries of category <" + category + ">:");
        for (Entry e : refList) {
            if (e.getCategory().equals(category)) {
                io.write("");
                io.write("Key: " + e.getMasterKey());
                io.write("Author: " + e.getAuthor());
                io.write("Title: " + e.getTitle());
            }
        }
    }

}
