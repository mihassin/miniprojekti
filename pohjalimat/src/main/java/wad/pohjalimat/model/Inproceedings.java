package wad.pohjalimat.model;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class Inproceedings {
    String author;
    String title;
    String booktitle;
    int year;
    
    // valinnaiset
    
    String editor;
    int volume;
    String series;
    int pages;
    String address;
    int month;
    String organisation;
    String publisher;
    String note;
    String key;
    
    public static Inproceedings create(String author, String title, String booktitle, int year) {
        return new Inproceedings(author, title, booktitle, year);
    }

    protected Inproceedings(String author, String title, String booktitle, int year) {
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public int getYear() {
        return year;
    }
    
    public String getEditor() {
        return editor;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public String getSeries() {
        return series;
    }
    
    public int getPages() {
        return pages;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getMont() {
        return month;
    }
    
    public String getPublisher() {
        return publisher;
    }
    
    public String getOrganisation() {
        return organisation;
    }
    
    public String getNote() {
        return note;
    }
    
    public String getKey() {
        return key;
    }
    
    // setterit
 
    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBooktitle(String bookTitle) {
        this.booktitle = bookTitle;
    }

    public void setYear(int year) {
        this.year = year;
    } 
    
    public void setEditor(String editor) {
        this.editor = editor;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
    
    public void setSeries(String series) {
        this.series = series;
    }
    
    public void setPages(int pages) {
        this.pages = pages;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 41 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 41 * hash + (this.booktitle != null ? this.booktitle.hashCode() : 0);
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
        final Inproceedings other = (Inproceedings) obj;
        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if ((this.booktitle == null) ? (other.booktitle != null) : !this.booktitle.equals(other.booktitle)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "*** " + title + " ***" + "\n" +
               "Author: " + author + "\n" +
               "Book title: " + booktitle + "\n" +
               "Year published: " + year + "\n";
    }
    
}
