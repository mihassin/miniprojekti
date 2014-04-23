/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.webcommands;

import java.util.ArrayList;
import java.util.HashMap;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.io.WebIO;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.uicommands.Addentry;
import wad.pohjalimat.uicommands.Bibtex;
import wad.pohjalimat.uicommands.Command;
import wad.pohjalimat.uicommands.Print;

/**
 *
 * @author Juhani Heliö
 */
public class WebAddEntryCommandStash {
    IO io;
    HashMap<String, Command> commands;
    ArrayList<Entry> refList;

    public WebAddEntryCommandStash(WebIO io) {
        this.io = io;
        commands = new HashMap<String, Command>();
        refList = new ArrayList<Entry>();
        
        commands.put("article", new WebAddArticle(io, refList));
    }

    public Command get(String readFromIO) {
        Command command = commands.get(readFromIO);
        if (command == null) {
            command = commands.get("help");
        }
        return command;
    }
         
    public ArrayList<Entry> getRefList() {
        return refList;
    }
}
