package wad.pohjalimat;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import wad.pohjalimat.io.IO;
import wad.pohjalimat.io.WebIO;
import wad.pohjalimat.uicommands.CommandStash;

@Service
public class WebUI {
    private final List<String> messages;
    WebIO io;
    CommandStash commands;
    
    public WebUI() {
        this.messages = new ArrayList<String>();
        io = new WebIO();
        commands = new CommandStash(io);
        io.write("Type 'help' for a list of available commands");
    }
    
    public void read(String message) {
        commands.get(message).run();
        
    }
    
    public List<String> write() {
        return io.getMessages();
    }
}
