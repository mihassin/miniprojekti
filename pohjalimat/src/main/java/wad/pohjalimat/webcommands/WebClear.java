package wad.pohjalimat.webcommands;

import wad.pohjalimat.io.WebIO;
import wad.pohjalimat.uicommands.Command;

public class WebClear implements Command{
    private WebIO io;
    
    public WebClear(WebIO io) {
        this.io = io;
    }
    
    @Override
    public void run() {
        io.clear();
        io.write("Type 'help' for a list of available commands");
    }
    
}
