

package wad.pohjalimat.io;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a helper class for easyB tests
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class StubIO implements IO {
    private String[] input;
    private List<String> output;
    private int iterator;
    
    
    public StubIO(String... lines) {
        this.input = lines;
        output = new ArrayList();
    }

    @Override
    public String read(String label) {
        if(iterator >= input.length) return "";
        return input[iterator++];
    }

    @Override
    public void write(String data) {
        output.add(data);
    }
    
    public List<String> getOutput() {
        return output;
    }    
    
}
