package wad.pohjalimat;

import java.util.List;
import org.springframework.stereotype.Service;
import wad.pohjalimat.io.WebIO;
import wad.pohjalimat.webcommands.WebAddEntryCommandStash;
import wad.pohjalimat.webcommands.WebCommands;

@Service
public class WebUI {
    private WebIO io;
    private WebCommands commands;
    private WebAddEntryCommandStash addentrycomms;
    private boolean addentryynMenossa=false;
    
    public WebUI() {
        io = new WebIO();
        commands = new WebCommands(io);
        addentrycomms = new WebAddEntryCommandStash(io);
        io.write("Type 'help' for a list of available commands");
    }
    
    public void read(String message) {
        if(addentryynMenossa){
            addentrycomms.get(message).run();
            addentryynMenossa=false;
        }
        if(message.equals("addentry")){
            addentryynMenossa=true;
            io.write("What kind of entry (article, book, inproceedings)?");
            return;
        }
        commands.get(message).run();
        
    }
    
    public List<String> write() {
        return io.getMessages();
    }
}
