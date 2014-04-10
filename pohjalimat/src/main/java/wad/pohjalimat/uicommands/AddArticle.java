/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Article;
import wad.pohjalimat.model.Entry;

/**
 *
 * @author Juhani Heliö
 */
public class AddArticle implements Command{

    IO io;
    ArrayList<Entry> refList;

    public AddArticle(IO io, ArrayList<Entry> refList) {
        this.io = io;
        this.refList = refList;
    }

    @Override
    public void run() {
        try {
            try {
                io.write("Compulsory information:");
                Article a=Article.create(
                        checkMasterKeyUniqueness(io.read("Reference key: ")),
                        io.read("author: "),
                        io.read("title: "),
                        io.read("journal: "),
                        Integer.parseInt(io.read("year: ")));
                
                io.write("Optional information (can be empty):");
                
                String apu=io.read("Number: ");
                a.setNumber(apu.isEmpty() ? 0 : Integer.parseInt(apu));
                
                apu=io.read("Pages: ");
                a.setPages(apu.isEmpty() ? null : apu);
                
                apu=io.read("Month (1-12): ");
                a.setMonthNumeric(apu.isEmpty() ? 0 : Integer.parseInt(apu));
                
                apu=io.read("Note: ");
                a.setNote(apu.isEmpty() ? null : apu);
                
                apu=io.read("Volume: ");
                a.setVolume(apu.isEmpty() ? 0 : Integer.parseInt(apu));
                
                refList.add(a);
            } catch (NullPointerException e) {
                io.write("");
                io.write("Invalid entry");
            }
        } catch (NumberFormatException e) {
            io.write("");
            io.write("Invalid nubmer entry");
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
