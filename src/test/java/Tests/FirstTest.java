package Tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.searchPageObject;
import lib.ui.factories.SaveArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.mainPageObject;
import lib.ui.saveArticles;
import org.junit.Test;

@Epic("Статьи")
public class FirstTest extends CoreTestCase {
    private mainPageObject mainPageObject;

    public void setUp() throws Exception
    {
        super.setUp();
        mainPageObject = new mainPageObject(driver);

    }

    @Test
    @Features(value = {@Feature(value = "Search")})
    @DisplayName("Search for article")
    @Description("Проверка падения теста")
    @Step("Начинаю тест Search for article")
    @Severity(value = SeverityLevel.NORMAL)
    public void testEx3 ()
    {
        mainPageObject.prepareScreenOrientation();
        searchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.searchInit();
        SearchPageObject.typeSearchLine("Java");
//        SearchPageObject.takeScreenShot("SearchResults");
//        cancelSearch cancelSearch = new cancelSearch(driver);
//        cancelSearch.waitForNumberOfResultsPresent();
//        cancelSearch.clearResults();
//        cancelSearch.checkElementsCleared();
        System.out.println("- Тест пройден успешно!");
    }
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
    @Features(value = {@Feature(value = "Search"),@Feature(value = "Article"),@Feature(value = "AddToFavorite")})
    @DisplayName("Compare articles")
    @Description("Авторизуемся, сохраняем две статьи, затем удаляем одну из них и проверяем что название оставшейся совпадает с ожидаемым")
    @Step("Начинаю тест Compare articles")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testEx5MW ()
    {
        searchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        saveArticles saveArticles = SaveArticlePageObjectFactory.get(driver);
        saveArticles.loginInWikiForMW();
        SearchPageObject.searchInit();
        saveArticles.saveTwoArticlesForMW();
        saveArticles.deleteOneAndAssert();
        System.out.println("- Тест пройден успешно!");
    }
}
