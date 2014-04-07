package wad.pohjalimat;

import wad.pohjalimat.io.IO;
import wad.pohjalimat.uicommands.CommandStash;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class TextUI {

    IO io;
    CommandStash commands;

    public TextUI(IO io) {
        this.io = io;
        commands = new CommandStash(io);
    }

    public void start() {
        while (true) {
            
            io.write("");
            io.write("Type 'help' for a list of available commands");

            String command = io.read("> ");
            commands.get(command).run();
        }
        
    }
    
    public CommandStash getCommandStash() {
        return commands;
    }
    
}
