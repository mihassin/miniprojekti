package wad.pohjalimat.model;

import wad.pohjalimat.util.aakkosetToBibTeX;

/**
 *
 * @author Lauri Kangassalo / lauri.kangassalo@helsinki.fi
 */
public class Inproceedings extends Entry {

    public static Inproceedings create(String masterKey, String author, String title, String booktitle, int year) {
        if (masterKey.isEmpty() || author.isEmpty() || title.isEmpty() || booktitle.isEmpty()) {
            throw new NullPointerException();
        }
        return new Inproceedings(masterKey, author, title, booktitle, year);
    }

    protected Inproceedings(String masterKey, String author, String title, String booktitle, int year) {
        this.masterKey = masterKey;
        this.author = author;
        this.title = title;
        this.booktitle = booktitle;
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

    @Override
    public String toString() {
        return "*** " + title + " ***\n"
                + AuthorToString()
                + BookTitleToString()
                + YearToString()
                + EditorToString()
                + VolumeToString()
                + SeriesToString()
                + PagesToString()
                + AddressToString()
                + MonthToString()
                + PublisherToString()
                + OrganisationToString()
                + NoteToString()
                + KeyToString();
    }

    @Override
    public String showEntryInBibTeX() {
        String raakamuoto = "@INPROCEEDINGS{" + masterKey + ",\n"
                + authorToBibTeX()
                + titleToBibTeX()
                + booktitleToBibTeX() 
                + yearToBibTeX()
                + editorToBibTeX()
                + volumeToBibTeX()
                + seriesToBibTeX()
                + pagesToBibTeX()
                + addressToBibTeX()
                + monthToBibTeX()
                + publisherToBibTeX()
                + organisationToBibTeX()
                + noteToBibTeX()
                + keyToBibTeX() + "}";

        return new aakkosetToBibTeX(raakamuoto).convert();
    }
}
