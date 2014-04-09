/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.model;

/**
 *
 * @author jphelio@cs
 */
public class Article extends Entry{
    
    private String journal;
    private int number;

    public static Article create(String masterKey, String author, String title, String journal, int year){
        if (masterKey.isEmpty() || author.isEmpty() || title.isEmpty() || journal.isEmpty() || year < -1000) {
            throw new IllegalArgumentException();
        }
        return new Article(masterKey, author, title, journal, year);
    }
    
    public Article(String masterKey, String author, String title, String journal, int year){
        super.masterKey=masterKey;
        super.author=author;
        super.title=title;
        this.journal=journal;
        super.year=year;
    }
    
//--Getterit ja setterit----------------
    
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
    
    
//--Overridet-------------------------
    
    @Override
    public String toString() {
        return null;
    }

    @Override
    public String showEntryInBibTeX() {
        return null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.journal != null ? this.journal.hashCode() : 0);
        hash = 43 * hash + this.number;
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
        if ((this.journal == null) ? (other.journal != null) : !this.journal.equals(other.journal)) {
            return false;
        }
        if (this.number != other.number) {
            return false;
        }
        return true;
    }
}
