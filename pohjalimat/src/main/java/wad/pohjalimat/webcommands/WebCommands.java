package wad.pohjalimat.webcommands;

import java.util.ArrayList;
import java.util.HashMap;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.io.WebIO;
import wad.pohjalimat.model.Inproceedings;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;
import wad.pohjalimat.uicommands.Addentry;
import wad.pohjalimat.uicommands.Bibtex;
import wad.pohjalimat.uicommands.Categorize;
import wad.pohjalimat.uicommands.Command;
import wad.pohjalimat.uicommands.Help;
import wad.pohjalimat.uicommands.Print;
import wad.pohjalimat.uicommands.Save;
import wad.pohjalimat.uicommands.Search;

public class WebCommands {
    IO io;
    HashMap<String, Command> commands;
    ArrayList<Entry> refList;

    public WebCommands(WebIO io) {
        this.io = io;
        commands = new HashMap<String, Command>();
        refList = new ArrayList<Entry>();
        
        commands.put("addentry", new Addentry(io, refList));
        //commands.put("categorize", new Categorize(io, refList));
        //commands.put("search", new Search(io, refList));
        commands.put("print", new Print(io, refList));
        commands.put("bibtex", new Bibtex(io, refList));
        commands.put("help", new WebHelp(io));
        commands.put("clear", new WebClear(io));
        //commands.put("save", new Save(io, refList));
        //ei voida käyttää komentoja jotka hyödyntävät io.readia webissä ennen readin ratkaisemista
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
