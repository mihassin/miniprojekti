package wad.pohjalimat.model;

import java.util.ArrayList;

/**
 *
 * @author lima-esa
 */
public class ReferenceList {
    
    protected ArrayList<Model> references;
    
    public ReferenceList() {
        this.references = new ArrayList<Model>();
    }
    
    public void add(Model reference) {
        references.add(reference);
    }
    
    public void printHumanReadable() {
        if (references.isEmpty()) {
            System.out.println("No saved records!");
        } else {
            for (Model model : references) {
                model.printHumanReadable();
            }
        }
    }
}
