package wad.pohjalimat.uicommands;

import wad.pohjalimat.io.IO;

/**
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
