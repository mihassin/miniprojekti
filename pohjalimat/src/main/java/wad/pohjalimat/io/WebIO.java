package wad.pohjalimat.io;

import com.sun.jndi.toolkit.url.Uri;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WebIO implements IO{
    private final List<String> messages;
    URL url;
    Scanner in;
    
    public WebIO() {
        this.messages = new ArrayList<String>();
        try{
        url=new URL("http://localhost:8084/pohjalimat/app/write");
        }
        catch(Exception e){
            System.out.println("url");
        }
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
