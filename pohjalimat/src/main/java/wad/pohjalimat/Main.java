package wad.pohjalimat;

import java.util.Scanner;
import wad.pohjalimat.io.ConsoleIO;
import wad.pohjalimat.model.Book;
import wad.pohjalimat.model.Inproceedings;

public class Main {
    public static void main(String[] args) {

        new TextUI(new ConsoleIO(new Scanner(System.in))).start();
    }

}
