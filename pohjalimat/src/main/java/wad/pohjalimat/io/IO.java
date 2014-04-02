
package wad.pohjalimat.io;

import wad.pohjalimat.model.Model;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public interface IO {
    public String read(String label);
    public void write(String data);
    public void printHumanReadableModel(Model model);
}
