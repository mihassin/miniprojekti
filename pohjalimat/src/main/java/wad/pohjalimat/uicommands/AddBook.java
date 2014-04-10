
package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Book;
import wad.pohjalimat.model.Entry;


public class AddBook implements Command{

    IO io;
    ArrayList<Entry> refList;

    public AddBook(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        try {
            try {
                io.write("Compulsory information:");
                Book b=Book.create(
                        checkMasterKeyUniqueness(io.read("Reference key: ")),
                        io.read("Author: "),
                        io.read("Title: "),
                        io.read("Publisher: "),
                        Integer.parseInt(io.read("Year: ")));
                
                // volume/number, series, address, edition, month, note, key
                io.write("Optional information(can be empty):");
                b.setVolume(Integer.parseInt(io.read("Volume: ")));
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
            io.write("Invalid entry");
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