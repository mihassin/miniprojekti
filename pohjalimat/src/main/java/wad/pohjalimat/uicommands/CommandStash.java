package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import java.util.HashMap;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.model.Inproceedings;

/**
 * CommandStash keeps track of all the commands available in the UI
 * 
 * @author slimer-esa
 */
public class CommandStash {
    IO io;
    HashMap<String, Command> commands;
    ArrayList<Inproceedings> refList;

    public CommandStash(IO io) {
        this.io = io;
        commands = new HashMap<String, Command>();
        refList = new ArrayList<Inproceedings>();
        
        commands.put("addentry", new Addentry(io, refList));
        commands.put("addbook", new Addentry(io, refList));
        commands.put("addarticle", new Addentry(io, refList));
        commands.put("print", new Print(io, refList));
        commands.put("bibtex", new Bibtex(io, refList));
        commands.put("exit", new Exit(io));
        commands.put("help", new Help(io));
        commands.put("save", new Save(io, refList));
    }

    public Command get(String readFromIO) {
        Command command = commands.get(readFromIO);
        if (command == null) {
            command = commands.get("help");
        }
        return command;
    }
         
    public ArrayList<Inproceedings> getRefList() {
        return refList;
    }
}