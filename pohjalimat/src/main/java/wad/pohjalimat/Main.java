package wad.pohjalimat;

import java.util.Scanner;
import wad.pohjalimat.io.ConsoleIO;
import wad.pohjalimat.model.Book;
import wad.pohjalimat.model.Inproceedings;

public class Main {
    public static void main(String[] args) {
        Book book = Book.create("viite2", "Make", "IP conffaus", "Unigrafia", 2014);
        System.out.println(book);
        System.out.println(book.showEntryInBibTeX());
//        new TextUI(new ConsoleIO(new Scanner(System.in))).start();
    }

}
