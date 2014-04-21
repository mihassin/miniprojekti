package wad.pohjalimat;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class WebUI {
    private final List<String> messages;
    
    public WebUI() {
        this.messages = new ArrayList<String>();
    }
    
    public void read(String message) {
        this.messages.add(message);
    }
    
    public List<String> write() {
        return messages;
    }
}
