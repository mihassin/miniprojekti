

package wad.pohjalimat.model;

/**
 * Class has variables for all possible entry data.
 * This data is managed via getters and setters in the implementation.
 * Class also provides toString methods and toBibTeX methods for all of its variables.
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public abstract class Entry {
    protected String masterKey;
    protected String author;
    protected String title;
    protected String publisher;
    protected int year;
    
    protected int volume;
    protected String series;
    protected String address;
    protected String edition;
    protected String month;
    protected String note;
    protected String key;
    
    protected String pages;
    protected String organisation;
    protected String booktitle;
    protected String editor;
    
    public Entry() {
        
    }
    
    @Override
    public abstract String toString();
    
    
    public abstract String showEntryInBibTeX();
    
    @Override
    public abstract boolean equals(Object obj);
    
    @Override
    public abstract int hashCode();
    
        protected String EditorToString() {
            return (editor.isEmpty()) ? "Editor: " + editor + "\n" : "";
        }
        
        protected String VolumeToString() {
            return (volume > -1) ? "Volume: " + volume + "\n" : "";
        }
        
        protected String SeriesToString() {
            return (series.isEmpty()) ? "Series: " + series + "\n" : "";
        }
        
        protected String PagesToString() {
            return (pages.isEmpty()) ? "Pages: " + pages + "\n" : "";
        }
        
        protected String AddressToString() {
            return (address.isEmpty()) ? "Address: " + address + "\n" : "";
        }
        
        protected String MonthToString() {
            return (month.isEmpty()) ? "Month: " + month + "\n" : "";
        }
        
        protected String PublisherToString() {
            return (publisher.isEmpty()) ? "Publisher: " + publisher + "\n" : "";
        }
        
        protected String OrganisationToString() {
            return (organisation.isEmpty()) ? "Organisation: " + organisation + "\n" : "";
        }
        
        protected String NoteToString() {
            return (note.isEmpty()) ? "Note: " + note + "\n" : "";
        }
        
        protected String KeyToString() {
            return (key.isEmpty()) ? "Key: " + key + "\n" : "";
        }
        
   
    
    

}
