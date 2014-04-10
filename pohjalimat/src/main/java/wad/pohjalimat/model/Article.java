/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.model;

/**
 *
 * @author Juhani Heliö
 */
public class Article extends Entry{
    
    private String journal;
    private int number;
    private int monthNumeric;

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

    public int getMonthNumeric() {
        return monthNumeric;
    }

    public void setMonthNumeric(int monthNumeric) {
        if(monthNumeric<=0){
            this.monthNumeric=0;
        }
        else if(monthNumeric>12){
            this.monthNumeric=12;
        }
        else{
        this.monthNumeric = monthNumeric;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMasterKey() {
        return masterKey;
    }

    public void setMasterKey(String masterKey) {
        this.masterKey = masterKey;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    
    
    
//--Overridet-------------------------
    
    @Override
    public String toString() {
        String optionals = "";

        if (number>0) {
            optionals = optionals + "Number: " + number + "\n";
        }
        if (pages!=null) {
            optionals = optionals + "Pages: " + pages + "\n";
        }
        if (month!=null) {
            optionals = optionals + "Month: " + month + "\n";
        }
        if (note!=null) {
            optionals = optionals + "Note: " + note + "\n";
        }
        if (volume>0) {
            optionals = optionals + "Volume: " + volume + "\n";
        }

        return "*** " + title + " ***" + "\n"
                + "Author: " + author + "\n"
                + "Journal: " + journal + "\n"
                + "Year published: " + year + "\n"
                + optionals;
    }

    @Override
    public String showEntryInBibTeX() {
        String optionals = "";
        
        if (number>=0) {
            optionals = optionals + ",\nnumber = " + number + ",\n";
        }
        if (pages!=null) {
            optionals = optionals + "pages = \"" + pages + "\",\n";
        }
        if (monthNumeric>0) {
            optionals = optionals + "month = " + monthNumeric + ",\n";
        }
        if (note!=null) {
            optionals = optionals + "note = \"" + note + "\",\n";
        }
        if (volume>0) {
            optionals = optionals + "volume = " + volume + "";
        }
        
        String raakamuoto = "@ARTICLE{" + masterKey +",\n" +
                "author = \"" + author + "\",\n"  +
                "title = \"" + title + "\",\n"  +
                "journal = \"" + journal + "\",\n"  +
                "year = " + year + ""  +
                optionals + "\n}";
        
        String amuunnos = raakamuoto.replace("ä", "\\\"{a}");
        String ajaomuunnos = amuunnos.replace("ö", "\\\"{o}");
        String muunnosA = ajaomuunnos.replace("Ä", "\\\"{A}");
        String muunnosAjaB = muunnosA.replace("Ö", "\\\"{O}");
        
        return muunnosAjaB;
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