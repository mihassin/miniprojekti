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
}
