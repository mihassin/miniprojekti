package wad.pohjalimat.model;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class Inproceedings {

    String masterKey;
    String author;
    String title;
    String booktitle;
    int year;

    // valinnaiset
    String editor;
    int volume;
    String series;
    String pages;
    String address;
    String month;
    String organisation;
    String publisher;
    String note;
    String key;

    public static Inproceedings create(String masterKey, String author, String title, String booktitle, int year) {
        if(masterKey.isEmpty() || author.isEmpty() || title.isEmpty() || booktitle.isEmpty()) throw new NullPointerException();
        return new Inproceedings(masterKey, author, title, booktitle, year);
    }

    protected Inproceedings(String masterKey, String author, String title, String booktitle, int year) {
        this.masterKey = masterKey;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
        this.year = year;

        //valinnaiset alustetaan {NULL} tai -1 arvoilla merkitsemään tyhjää:
        this.editor = "{NULL}";
        this.volume = -1;
        this.series = "{NULL}";
        this.pages = "{NULL}";
        this.address = "{NULL}";
        this.month = "{NULL}";
        this.publisher = "{NULL}";
        this.organisation = "{NULL}";
        this.note = "{NULL}";
        this.key = "{NULL}";
    }

    public String getMasterKey() {
        return masterKey;
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

    public String getPages() {
        return pages;
    }

    public String getAddress() {
        return address;
    }

    public String getMonth() {
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

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMonth(String month) {
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
        String optionals = "";

        if (!editor.equals("{NULL}")) {
            optionals = optionals + "Editor: " + editor + "\n";
        }
        if (volume > -1) {
            optionals = optionals + "Volume: " + volume + "\n";
        }
        if (!series.equals("{NULL}")) {
            optionals = optionals + "Series: " + series + "\n";
        }
        if (!pages.equals("{NULL}")) {
            optionals = optionals + "Pages: " + pages + "\n";
        }
        if (!address.equals("{NULL}")) {
            optionals = optionals + "Address: " + address + "\n";
        }
        if (!month.equals("{NULL}")) {
            optionals = optionals + "Month: " + month + "\n";
        }
        if (!publisher.equals("{NULL}")) {
            optionals = optionals + "Publisher: " + publisher + "\n";
        }
        if (!organisation.equals("{NULL}")) {
            optionals = optionals + "Organisation: " + organisation + "\n";
        }
        if (!note.equals("{NULL}")) {
            optionals = optionals + "Note: " + note + "\n";
        }
        if (!key.equals("{NULL}")) {
            optionals = optionals + "Key: " + key + "\n";
        }

        return "*** " + title + " ***" + "\n"
                + "Author: " + author + "\n"
                + "Book title: " + booktitle + "\n"
                + "Year published: " + year + "\n"
                + optionals;
    }

    public String showEntryInBibTeX() {
        String optionals = "";
        
        if (!editor.equals("{NULL}")) {
            optionals = optionals + "editor = \"" + editor + "\",\n";
        }
        if (volume > -1) {
            optionals = optionals + "volume = \"" + volume + "\",\n";
        }
        if (!series.equals("{NULL}")) {
            optionals = optionals + "series = \"" + series + "\",\n";
        }
        if (!pages.equals("{NULL}")) {
            optionals = optionals + "pages = \"" + pages + "\",\n";
        }
        if (!address.equals("{NULL}")) {
            optionals = optionals + "address = \"" + address + "\",\n";
        }
        if (!month.equals("{NULL}")) {
            optionals = optionals + "month = \"" + month + "\",\n";
        }
        if (!publisher.equals("{NULL}")) {
            optionals = optionals + "publisher = \"" + publisher + "\",\n";
        }
        if (!organisation.equals("{NULL}")) {
            optionals = optionals + "organisation = \"" + organisation + "\",\n";
        }
        if (!note.equals("{NULL}")) {
            optionals = optionals + "note = \"" + note + "\",\n";
        }
        if (!key.equals("{NULL}")) {
            optionals = optionals + "key = \"" + key + "\",\n";
        }
        
        String raakamuoto = "@INPROCEEDINGS{" + masterKey +",\n" +
                "author = \"" + author + "\",\n"  +
                "title = \"" + title + "\",\n"  +
                "booktitle = \"" + booktitle + "\",\n"  +
                "year = \"" + year + "\",\n"  +
                optionals + "}";
        
        String amuunnos = raakamuoto.replace("ä", "\\\"{a}");
        String ajaomuunnos = amuunnos.replace("ö", "\\\"{o}");
        String muunnosA = ajaomuunnos.replace("Ä", "\\\"{A}");
        String muunnosAjaB = muunnosA.replace("Ö", "\\\"{O}");
        
        return muunnosAjaB;
    }
}
