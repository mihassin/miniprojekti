package wad.pohjalimat.model;

/**
 * Class has variables for all possible entry data. This data is managed via
 * getters and setters in the implementation. Class also provides toString
 * methods and toBibTeX methods for all of its variables.
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
    protected String journal;
    protected int number;

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
        return (isNotNullOrEmpty(editor)) ? "Editor: " + editor + "\n" : "";
    }

    protected String VolumeToString() {
        return (volume > 0) ? "Volume: " + volume + "\n" : "";
    }

    protected String SeriesToString() {
        return (isNotNullOrEmpty(series)) ? "Series: " + series + "\n" : "";
    }

    protected String PagesToString() {
        return (isNotNullOrEmpty(pages)) ? "Pages: " + pages + "\n" : "";
    }

    protected String AddressToString() {
        return (isNotNullOrEmpty(address)) ? "Address: " + address + "\n" : "";
    }

    protected String MonthToString() {
        return (isNotNullOrEmpty(month)) ? "Month: " + month + "\n" : "";
    }

    protected String PublisherToString() {
        return (isNotNullOrEmpty(publisher)) ? "Publisher: " + publisher + "\n" : "";
    }

    protected String OrganisationToString() {
        return (isNotNullOrEmpty(organisation)) ? "Organisation: " + organisation + "\n" : "";
    }

    protected String NoteToString() {
        return (isNotNullOrEmpty(note)) ? "Note: " + note + "\n" : "";
    }

    protected String KeyToString() {
        return (isNotNullOrEmpty(key)) ? "Key: " + key + "\n" : "";
    }

    protected String AuthorToString() {
        return (isNotNullOrEmpty(author)) ? "Author: " + author + "\n" : "";
    }

    protected String TitleToString() {
        return (isNotNullOrEmpty(title)) ? "Title: " + title + "\n" : "";
    }

    protected String YearToString() {
        return "Year: " + year + "\n";
    }

    protected String EditionToString() {
        return (isNotNullOrEmpty(edition)) ? "Edition: " + edition + "\n" : "";
    }

    public String getMasterKey() {
        return masterKey;
    }

    private boolean isNotNullOrEmpty(String value) {
        return value != null && !value.isEmpty();
    }
    
    // Enter setters & getters
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
