package wad.pohjalimat.model;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class Book extends Entry {

    public static Book create(String masterKey, String author, String title, String publisher, int year) {
        if (masterKey.isEmpty() || author.isEmpty() || title.isEmpty() || publisher.isEmpty() || year < 0) {
            throw new IllegalArgumentException();
        }
        return new Book(masterKey, author, title, publisher, year);
    }

    public Book(String masterKey, String author, String title, String publisher, int year) {
        super.masterKey = masterKey;
        super.author = author;
        super.title = title;
        super.publisher = publisher;
        super.year = year;
    }
    
    
    
   @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 41 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 41 * hash + (this.publisher != null ? this.publisher.hashCode() : 0);
        hash = 41 * hash + this.year;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (this.author.equals(other.author)) {
            return false;
        }
        if (this.title.equals(other.title)) {
            return false;
        }
        if (this.publisher.equals(other.publisher)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "*** " + title + " ***\n"
                + AuthorToString()
                + PublisherToString()
                + YearToString()
                + VolumeToString()
                + SeriesToString()
                + AddressToString()
                + EditionToString()
                + MonthToString()
                + NoteToString()
                + KeyToString(); 
    }
    
    // volume/number, series, address, edition, month, note, key

   @Override
   public String showEntryInBibTeX() {
               String optionals = "";
        
        if (volume>0) {
            optionals = optionals + "volume = " + volume + ",\n";
        }
        if (series!=null && !series.isEmpty()) {
            optionals = optionals + "series = \"" + series + "\",\n";
        }
        if (address!=null && !address.isEmpty()) {
            optionals = optionals + "address = \"" + address + "\",\n";
        }
        if(edition!=null && !edition.isEmpty()) {
            optionals = optionals + "edition = \"" + edition + "\",\n";
        }
        if(month!=null && !month.isEmpty()) {
            optionals = optionals + "month = " + address + ",\n";
        }
        
        
        if (note!=null && !note.isEmpty()) {
            optionals = optionals + "note = \"" + note + "\",\n";
        }
        
        if (key!=null && !key.isEmpty()) {
            optionals = optionals + "isbn = \"" + key + "\",\n";
        }
        String raakamuoto = "@BOOK{" + masterKey +",\n" +
                "author = \"" + author + "\",\n"  +
                "title = \"" + title + "\",\n"  +
                "publisher = \"" + publisher + "\",\n"  +
                "year = " + year + ",\n"  +
                optionals + "}";
        
        String amuunnos = raakamuoto.replace("ä", "\\\"{a}");
        String ajaomuunnos = amuunnos.replace("ö", "\\\"{o}");
        String muunnosA = ajaomuunnos.replace("Ä", "\\\"{A}");
        String muunnosAjaB = muunnosA.replace("Ö", "\\\"{O}");
        
        return muunnosAjaB;
   }
   
    
    
    
    
    

}
