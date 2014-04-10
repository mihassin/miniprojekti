/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wad.pohjalimat.uicommands;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import wad.pohjalimat.io.StubIO;
import wad.pohjalimat.model.Article;
import wad.pohjalimat.model.Entry;
import wad.pohjalimat.model.Inproceedings;

/**
 *
 * @author Juhani Heliö
 */
public class AddArticleTest {
    
    ArrayList<Entry> testRefList;
    StubIO testIO;
    Inproceedings testInproceedings;
    AddArticle testAddArticle;
    
    public AddArticleTest() {
    }
    
    @Before
    public void setUp() {
        testIO = new StubIO();
        testRefList = new ArrayList<Entry>();
        testAddArticle = new AddArticle(testIO, testRefList);
    }

    @Test
    public void addingANewArticle () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed () {
        testIO = new StubIO(null, "writerguy", "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed2 () {
        testIO = new StubIO("masterkey", null, "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed3 () {
        testIO = new StubIO("masterkey", "writerguy", null, "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed4 () {
        testIO = new StubIO("masterkey", "writerguy", "work", null, "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testIO.getOutput().contains("Invalid entry"));
    }
    
    @Test
    public void addingANewEntryWithEmptyRequiredFieldFailsAndUserIsInformed5 () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testIO.getOutput().contains("Invalid nubmer entry"));
    }
    
//    @Test
//    public void addingANewEntryWithEmptyRequiredFieldsFailsAndUserIsInformed () {
//        testIO = new StubIO("", "", "", "", "");
//        testAddArticle = new AddArticle(testIO, testRefList);
//        testAddArticle.run();
//        
//        assertTrue(testIO.getOutput().contains("Invalid entry"));
//    }
//    
//    @Test
//    public void addingANewEntryWithInvalidPublishYearFailsAndUserIsInformed () {
//        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "invalid");
//        testAddArticle = new AddArticle(testIO, testRefList);
//        testAddArticle.run();
//        
//        assertTrue(testIO.getOutput().contains("Invalid number entry"));
//    }
    
    @Test
    public void addingANewEntryWithDuplicateMasterKeyIsHandled () {
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        testIO = new StubIO("just testing masterkey", "writerguy", "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        testIO = new StubIO("masterkey", "writerguy", "work", "work list", "2014");
        testAddArticle = new AddArticle(testIO, testRefList);
        testAddArticle.run();
        
        assertTrue(testRefList.get(0).getMasterKey().equals("masterkey"));
        assertTrue(testRefList.get(2).getMasterKey().equals("masterkey__1"));
        assertTrue(testRefList.get(3).getMasterKey().equals("masterkey__2"));
    }
    
}
