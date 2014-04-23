package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Article;
import wad.pohjalimat.model.Book;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author lima-esa & co
 */
public class Addentry implements Command {

    IO io;
    ArrayList<Entry> refList;

    public Addentry(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        io.write("");
        io.write("Available types: article, book, inproceedings");
        String type = io.read("What kind of entry would you like to add? ");
        addEntryOfType(type);
    }

    private void addEntryOfType(String type) {
        if (type.equals("article")) {
            addArticle();
        } else if (type.equals("book")) {
            addBook();
        } else if (type.equals("inproceedings")) {
            addInproceedings();
        } else {
            io.write("Nothing was added");
        }
    }

    private void addArticle() {
        try {
            try {
                io.write("Compulsory information:");
                Article a = Article.create(
                        checkMasterKeyUniqueness(io.read("Reference key: ")),
                        io.read("Author: "),
                        io.read("Title: "),
                        io.read("Journal: "),
                        Integer.parseInt(io.read("(Number) Year: ")));

                io.write("Optional information (can be empty):");

                String apu = io.read("(Number) Number: ");
                a.setNumber(apu.isEmpty() ? 0 : Integer.parseInt(apu));

                apu = io.read("Pages: ");
                a.setPages(apu.isEmpty() ? null : apu);

                apu = io.read("(Number) Month (1-12): ");
                a.setMonthNumeric(apu.isEmpty() ? 0 : Integer.parseInt(apu));

                apu = io.read("Note: ");
                a.setNote(apu.isEmpty() ? null : apu);

                apu = io.read("(Number) Volume: ");
                a.setVolume(apu.isEmpty() ? 0 : Integer.parseInt(apu));

                refList.add(a);
            } catch (NullPointerException e) {
                io.write("");
                io.write("Invalid entry");
            }
        } catch (NumberFormatException e) {
            io.write("");
            io.write("Invalid number entry");
        }
    }

    private void addBook() {
        try {
            try {
                io.write("Compulsory information:");
                Book b = Book.create(
                        checkMasterKeyUniqueness(io.read("Reference key: ")),
                        io.read("Author: "),
                        io.read("Title: "),
                        io.read("Publisher: "),
                        Integer.parseInt(io.read("(Number) Year: ")));

                // volume/number, series, address, edition, month, note, key
                io.write("Optional information(can be empty):");
                String vol = io.read("(Number) Volume: ");
                if (!vol.isEmpty()) {
                    b.setVolume(Integer.parseInt(vol));
                }
                b.setSeries(io.read("Series: "));
                b.setAddress(io.read("Address: "));
                b.setEdition(io.read("Edition: "));
                b.setMonth(io.read("Month: "));
                b.setNote(io.read("Note: "));
                b.setKey(io.read("ISBN: "));

                refList.add(b);
            } catch (IllegalArgumentException e) {
                io.write("");
                io.write("Invalid entry");
            }
        } catch (NumberFormatException e) {
            io.write("");
            io.write("Invalid number entry");
        }
    }

    private void addInproceedings() {
        try {
            try {
                io.write("Compulsory information:");
                Inproceedings i = Inproceedings.create(
                        checkMasterKeyUniqueness(io.read("Reference key: ")),
                        io.read("Author: "),
                        io.read("Title: "),
                        io.read("Booktitle: "),
                        Integer.parseInt(io.read("(Number) Year: ")));

                // editor, volume/number, series, address, month, publisher, organisation, note, key
                io.write("Optional information(can be empty):");
                i.setEditor(io.read("Editor: "));
                String vol = io.read("(Number) Volume: ");
                if (!vol.isEmpty()) {
                    i.setVolume(Integer.parseInt(vol));
                }
                i.setSeries(io.read("Series: "));
                i.setPages(io.read("Pages: "));
                i.setAddress(io.read("Address: "));
                i.setMonth(io.read("Month: "));
                i.setPublisher(io.read("Publisher: "));
                i.setOrganisation(io.read("Organisation: "));
                i.setNote(io.read("Note: "));
                i.setKey(io.read("ISBN: "));

                refList.add(i);
            } catch (NullPointerException e) {
                io.write("");
                io.write("Invalid entry");
            }
        } catch (NumberFormatException e) {
            io.write("");
            io.write("Invalid number entry");
        }
    }

    /**
     * Checks for known duplicates for given masterKey and if one is found,
     * returns the same key with an unique index number. Example: "masterKey" is
     * found --> returns "masterKey__1", "masterKey__1" is found --> returns
     * "masterKey__2".
     *
     * @param masterKey bibTex cite key that is checked for duplicates
     * @return unique masterKey
     */
    private String checkMasterKeyUniqueness(String masterKey) {
        int keyDuplicateIndex = 1;
        boolean theSearchIsOn = true;
        String dupeKey = masterKey;

        while (theSearchIsOn) {
            theSearchIsOn = false;
            for (Entry ref : refList) {
                if (ref.getMasterKey().equals(dupeKey)) {
                    // duplicate key is found from previous entries
                    dupeKey = masterKey + "__" + keyDuplicateIndex;
                    keyDuplicateIndex++;
                    theSearchIsOn = true;
                    // search for a duplicate for the indexed key
                }
            }
        }
        return dupeKey;
    }
}
