package wad.pohjalimat;

import java.util.List;
import org.springframework.stereotype.Service;
import wad.pohjalimat.io.WebIO;
import wad.pohjalimat.webcommands.WebCommands;

@Service
public class WebUI {
    WebIO io;
    WebCommands commands;
    
    public WebUI() {
        io = new WebIO();
        commands = new WebCommands(io);
        io.write("Type 'help' for a list of available commands");
    }
    
    public void read(String message) {
        commands.get(message).run();
        
    }
    
    public List<String> write() {
        return io.getMessages();
    }
}
