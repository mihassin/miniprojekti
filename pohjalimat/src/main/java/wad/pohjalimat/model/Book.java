package wad.pohjalimat.model;

import wad.pohjalimat.util.aakkosetToBibTeX;

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
        String raakamuoto = "@BOOK{" + masterKey + ",\n"
                + authorToBibTeX()
                + titleToBibTeX()
                + publisherToBibTeX()
                + yearToBibTeX()
                + volumeToBibTeX()
                + seriesToBibTeX()
                + addressToBibTeX() 
                + editionToBibTeX() 
                + monthToBibTeX()
                + noteToBibTeX() 
                + keyToBibTeX() + "}";

        return new aakkosetToBibTeX(raakamuoto).convert();
    }
}
