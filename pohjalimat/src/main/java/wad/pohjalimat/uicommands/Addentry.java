package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author lima-esa
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
        try {
            try {
                io.write("Compulsory information:");
                Inproceedings i = Inproceedings.create(
                        checkMasterKeyUniqueness(io.read("Reference key: ")),
                        io.read("author: "),
                        io.read("title: "),
                        io.read("booktitle: "),
                        Integer.parseInt(io.read("year: ")));

                // editor, volume/number, series, address, month, publisher, organisation, note, key
                io.write("Optional information(can be empty):");
                i.setEditor(io.read("Editor: "));
                String vol = io.read("Volume: ");
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
