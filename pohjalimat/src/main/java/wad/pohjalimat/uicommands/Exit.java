package wad.pohjalimat.uicommands;

import wad.pohjalimat.io.IO;

/**
 * System.exit() screws easyB tests up so the command is handled in the class
 * TextUI for the time being.
 * 
 * @author slime- eazy-e
 */
public class Exit implements Command {

    IO io;

    public Exit(IO io) {
        this.io = io;
    }
    
    @Override
    public void run() {
        System.exit(0);
    }
    
}
