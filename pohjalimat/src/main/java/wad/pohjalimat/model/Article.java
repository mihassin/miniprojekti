/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.pohjalimat.model;

import wad.pohjalimat.util.aakkosetToBibTeX;

/**
 *
 * @author Juhani Heliö
 */
public class Article extends Entry {

    private int monthNumeric;

    public static Article create(String masterKey, String author, String title, String journal, int year) {
        if (masterKey.isEmpty() || author.isEmpty() || title.isEmpty() || journal.isEmpty() || year < -1000) {
            throw new IllegalArgumentException();
        }
        return new Article(masterKey, author, title, journal, year);
    }

    public Article(String masterKey, String author, String title, String journal, int year) {
        super.masterKey = masterKey;
        super.author = author;
        super.title = title;
        this.journal = journal;
        super.year = year;
    }

//--Getterit ja setterit----------------
    public void setMonthNumeric(int monthNumeric) {
        if (monthNumeric <= 0) {
            this.month = "" + 0;
        } else if (monthNumeric > 12) {
            this.month = "" + 12;
        } else {
            this.month = "" + monthNumeric;
        }
    }

    public int getMonthNumeric() {
        int month = 0;
        try {
            month = Integer.parseInt(this.month);
        } catch (Exception e) {
        }
        return month;
    }

//--Overridet-------------------------
    @Override
    public String toString() {
        return "*** " + title + " ***" + "\n"
                + AuthorToString()
                + JournalToString()
                + YearToString()
                + NumberToString()
                + PagesToString()
                + MonthToString()
                + NoteToString()
                + VolumeToString();
    }

    @Override
    public String showEntryInBibTeX() {
        String raakamuoto = "@ARTICLE{" + masterKey + ",\n"
                + authorToBibTeX()
                + titleToBibTeX()
                + journalToBibTeX()
                + yearToBibTeX()
                + numberToBibTeX()
                + pagesToBibTeX()
                + monthToBibTeX()
                + noteToBibTeX()
                + volumeToBibTeX() + "}";

        return new aakkosetToBibTeX(raakamuoto).convert();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.masterKey != null ? this.masterKey.hashCode() : 0);
        hash = 43 * hash + (this.author != null ? this.author.hashCode() : 0);
        hash = 43 * hash + (this.title != null ? this.title.hashCode() : 0);
        hash = 43 * hash + (this.journal != null ? this.journal.hashCode() : 0);
        hash = 43 * hash + this.year;
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
        final Article other = (Article) obj;
        if ((this.masterKey == null) ? (other.masterKey != null) : !this.masterKey.equals(other.masterKey)) {
            return false;
        }
        if ((this.author == null) ? (other.author != null) : !this.author.equals(other.author)) {
            return false;
        }
        if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
            return false;
        }
        if ((this.journal == null) ? (other.journal != null) : !this.journal.equals(other.journal)) {
            return false;
        }
        if (this.year != other.year) {
            return false;
        }
        return true;
    }
}