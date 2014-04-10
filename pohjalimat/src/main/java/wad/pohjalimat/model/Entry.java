

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
            return (editor!=null) ? "Editor: " + editor + "\n" : "";
        }
        
        protected String VolumeToString() {
            return (volume > 0) ? "Volume: " + volume + "\n" : "";
        }
        
        protected String SeriesToString() {
            return (series!=null) ? "Series: " + series + "\n" : "";
        }
        
        protected String PagesToString() {
            return (pages!=null) ? "Pages: " + pages + "\n" : "";
        }
        
        protected String AddressToString() {
            return (address!=null) ? "Address: " + address + "\n" : "";
        }
        
        protected String MonthToString() {
            return (month!=null) ? "Month: " + month + "\n" : "";
        }
        
        protected String PublisherToString() {
            return (publisher!=null) ? "Publisher: " + publisher + "\n" : "";
        }
        
        protected String OrganisationToString() {
            return (organisation!=null) ? "Organisation: " + organisation + "\n" : "";
        }
        
        protected String NoteToString() {
            return (note!=null) ? "Note: " + note + "\n" : "";
        }
        
        protected String KeyToString() {
            return (key!=null) ? "Key: " + key + "\n" : "";
        }
        
        protected String AuthorToString() {
            return (author!=null) ? "Author: " + author + "\n" : "";
        }
        
        protected String TitleToString() {
            return (title!=null) ? "Title: " + title + "\n" : "";
        }
        
        protected String YearToString() {
            return "Year: " + year + "\n";
        }
        
        protected String EditionToString() {
            return (edition!=null) ? "Edition: " + edition + "\n" : "";
        }

    public String getMasterKey() {
        return masterKey;
    }
        
        
   
    
    

}
