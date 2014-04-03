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
    
}
