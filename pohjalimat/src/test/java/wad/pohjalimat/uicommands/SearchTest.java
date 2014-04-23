package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Article;
import wad.pohjalimat.model.Book;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author eski
 */
public class SearchTest {

    StubIO testIO;
    ArrayList<Entry> testRefList;
    Search testSearch;
    Inproceedings testInproceedings;
    Book testBook;
    Article testArticle;

    public SearchTest() {
    }

    @Before
    public void setUp() {
        testRefList = new ArrayList<Entry>();
        testInproceedings = Inproceedings.create("inproMaster", "writer guy", "sell & buy", "best open source gui", 2014);
        testArticle = Article.create("articleMaster", "writer guy", "writerguy", "work", 2014);
        testBook = Book.create("bookMaster", "writer guy", "writerguy", "work", 2014);
        testRefList.add(testInproceedings);
        testRefList.add(testArticle);
        testRefList.add(testBook);
        testIO = new StubIO("2");
        testSearch = new Search(testIO, testRefList);
    }

    @Test
    public void listsCorrectCategory() {
        testInproceedings.setCategory("inprokategoria");
        testArticle.setCategory("articlekategoria");
        testBook.setCategory("bookkategoria");
        testSearch.run();
        assertTrue(testIO.getOutput().contains("Entries of category <articlekategoria>:"));
    }
    
    @Test
    public void noCategoriesHandled() {
        testSearch.run();
        assertTrue(testIO.getOutput().contains("There are no added categories"));
    }
    
}
