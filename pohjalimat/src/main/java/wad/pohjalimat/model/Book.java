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
    
    

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        if (!this.author.equals(other.author)) {
            return false;
        }
        if (!this.title.equals(other.title)) {
            return false;
        }
        if (!this.publisher.equals(other.publisher)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
   public String showEntryInBibTeX() {
       return "";
   }
   
    
    
    
    
    

}
