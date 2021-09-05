package Tests;

import lib.CoreTestCase;
import lib.ui.cancelSearch;
import lib.ui.SearchPageObject;
import lib.ui.factories.SaveArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.mainPageObject;
import lib.ui.SaveArticles;
import org.junit.Test;


public class FirstTest extends CoreTestCase {
    private mainPageObject mainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();
        mainPageObject = new mainPageObject(driver);

    }

//    @Test
//    public void testEx3 ()
//    {
//        mainPageObject.prepareScreenOrientation();
//        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
//        SearchPageObject.searchInit();
//        SearchPageObject.typeSearchLine("Java");
//        cancelSearch cancelSearch = new cancelSearch(driver);
//        cancelSearch.waitForNumberOfResultsPresent();
//        cancelSearch.clearResults();
//        cancelSearch.checkElementsCleared();
//        System.out.println("- Тест пройден успешно!");
//    }
//
//    @Test
//    public void testEx5 ()
//    {
//        mainPageObject.prepareScreenOrientation();
//        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
//        SearchPageObject.searchInit();
//        SearchPageObject.typeSearchLine("Java");
//        SaveArticles saveArticles = SaveArticlePageObjectFactory.get(driver);
//        saveArticles.waitForFirstArticlePresentSaveAndExitToMainPage();
//        SearchPageObject.searchInit();
//        SearchPageObject.typeSearchLine("Dzigurda");
//        saveArticles.waitForSecondArticlePresentSaveAndExitToMainPage();
//        saveArticles.openSavedArticlesAndDeleteOne();
//        saveArticles.confirmSecondAndCheckTitle();
//        System.out.println("- Тест пройден успешно!");
//    }
//
//    @Test
//    public void testEx6 ()
//    {
//        mainPageObject.prepareScreenOrientation();
//        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
//        SearchPageObject.searchInit();
//        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.waitForSearchResultAndClick("Java (programming language");
//        mainPageObject.assertElementPresent("org.wikipedia:id/view_page_title_text","Элемент не найден по id");
//        System.out.println("- Тест пройден успешно!");
//    }

    @Test
    public void testEx5MW ()
    {
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SaveArticles saveArticles = SaveArticlePageObjectFactory.get(driver);
        saveArticles.loginInWikiForMW();
        SearchPageObject.searchInit();
        SearchPageObject.typeSearchLine("Java");
        saveArticles.saveTwoArticlesForMW();
        saveArticles.deleteOneAndAssert();
        System.out.println("- Тест пройден успешно!");
    }
}
