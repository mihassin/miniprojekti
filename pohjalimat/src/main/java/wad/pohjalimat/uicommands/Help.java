package wad.pohjalimat.uicommands;

import wad.pohjalimat.io.IO;

/**
 *
 * @author slime-esa
 */
public class Help implements Command {

    IO io;

    public Help(IO io) {
        this.io = io;
    }

    @Override
    public void run() {
        io.write("");
        io.write("Available commands:");
        io.write("addentry - add an inproceedings BibTex entry");
        io.write("print    - print a list of added content");
        io.write("bibtex   - print a list of added content in BibTex format");
        io.write("save     - save the added content in BibTex format to a .bib file");
        io.write("help     - this little manual");
        io.write("exit     - quit the program");
    }
}
