package wad.pohjalimat.io;

import java.util.ArrayList;
import java.util.List;

public class WebIO implements IO{
    private final List<String> messages;
    
    public WebIO() {
        this.messages = new ArrayList<String>();
    }
    
    @Override
    public String read(String label) {
        messages.add(label); // webio tarvitsee jonkinlaisen toimivan read ratkaisun.
        return label;
    }
    
    @Override
    public void write(String data) {
        messages.add(data);
    }
    
    public List<String> getMessages() {
        return messages;
    }
    
    public void clear() {
        messages.clear();
    }
}
