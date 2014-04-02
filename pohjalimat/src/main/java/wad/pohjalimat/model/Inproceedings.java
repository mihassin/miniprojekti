package wad.pohjalimat.model;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class Inproceedings implements Model {
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

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getBooktitle() {
        return booktitle;
    }

    @Override
    public int getYear() {
        return year;
    }
}
