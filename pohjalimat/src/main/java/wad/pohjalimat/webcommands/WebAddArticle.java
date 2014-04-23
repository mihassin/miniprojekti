/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.webcommands;

import java.util.ArrayList;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Article;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.uicommands.Command;

/**
 *
 * @author Juhani Heliö
 */
public class WebAddArticle implements Command{
    
    IO io;
    ArrayList<Entry> refList;
    
    public WebAddArticle(IO io, ArrayList<Entry> refList){
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

    @Override
    public void run() {
       new WebAddArticle(io, refList);
    }
}
