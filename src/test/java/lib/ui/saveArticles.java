package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class saveArticles extends mainPageObject{

    protected static String
            ARTICLE1_CONTAINS_TEXT,
            ARTICLE2_CONTAINS_TEXT,
            CLOSE_BTTN ,
            ONBOARDING_BTN,
            NAME_OF_LIST,
            OK_BTTN,
            NEW_LIST_ELEM,
            SAVE_ARTICLE_BTTN,
            ITEM_TITLE,
            SECOND_TITLE,
            SECOND_ARTICLE_TITLE,
            LOG_IN_BUTTON,
            LOGIN_FIELD,
            MENU_BTTN,
            PASS_FIELD,
            CHECK_IN_BTTN,
            FIND_BTTN,
            SEARCH_FIELD,
            WATCH_LIST,
            UNLIKE_ARTICLE1,
            SAVED_ARTICLE_HREF,
            UNLIKE,
            UNLIKED_BUTTON,
            ARTICLE_TITLE;



    public saveArticles(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void waitForFirstArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(ARTICLE1_CONTAINS_TEXT, "Элемент в выпадающем списке поиска не найден",
                15);
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Элемент сохранения не найден",
                15);
        this.waitForElemAndClick(ONBOARDING_BTN,
                "Кнопка онбординга Got It не найдена",
                10);
        this.waitForElemAndClear( NAME_OF_LIST,
                "Обьект 'Имя листа' не отображается в течении 5 секунд",
                5);
        this.waitForElemByAndSendKeys(
                NAME_OF_LIST,
                "New list",
                "Обьект 'Имя листа' не отображается в течении 5 секунд",
                5);
        this.waitForElemAndClick(OK_BTTN,
                "Элемент кнопки ОК не найден",
                15);
        this.waitForElemAndClick(CLOSE_BTTN,"Элемент X не найден", 10);
    }

    @Step("Авторизация в wiki")
    public void loginInWikiForMW()
    {
        this.waitForElemAndClick(MENU_BTTN, "Элемент открытия бокового меню не найден", 10);
        this.waitForElemAndClick(LOG_IN_BUTTON, "Кнопка авторизации не найдена", 10);
        this.waitForElemByAndSendKeys(LOGIN_FIELD,"TestApium","Не могу найти поле ввода логина",10);
        this.waitForElemByAndSendKeys(PASS_FIELD,"testappium","Не могу найти поле ввода пароля",10);
        this.waitForElemAndClick(CHECK_IN_BTTN,"Не могу найти кнопку логина", 10);

    }

    @Step("Проверка появилась ли иконка статьи добавленной в список для чтения")
    public Boolean isElementPresent(String locator)
    {
        return getAmountOfElem(locator)>0;
    }

    @Step("Если статья не добавлена в список для чтения - добавляем, если добавлена - идем дальше")
    public void unlikeArticle()
    {
        if (this.isElementPresent(UNLIKE)) {
           this.waitForElemAndClick(UNLIKE,"Не могу кликнуть по кнопке",20);
        }
        else
        {
            this.waitForElem(UNLIKED_BUTTON, "Кнопка не сохраненной статьи не найдена",15);
        }
    }

    @Step("Набираю в строке поисковый запрос: '{search_line}'")
    public void typeSearchLine(String search_line)
    {
        this.waitForElemByAndSendKeys(SEARCH_FIELD, search_line, "Не могу найти вводимое слово в сторку поиска",15);
    }

    @Step("Сохраняем две статьи и переходим к списку для чтения")
    public void saveTwoArticlesForMW()
    {
        this.typeSearchLine("Java");
        this.waitForElemAndClick(ARTICLE1_CONTAINS_TEXT, "Элемент в выпадающем списке поиска не найден",
                15);
        this.waitForElem(ARTICLE_TITLE,"Элемент заголовка не появился",15);
        this.unlikeArticle();
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Элемент сохранения не найден",
                15);
        this.waitForElemAndClick(FIND_BTTN,"Не могу найти кнопку поиска",10);
        this.typeSearchLine("Dzigurda");

        this.waitForElemAndClick(ARTICLE2_CONTAINS_TEXT,"Не могу найти вторую статью", 10);
        this.waitForElem(ARTICLE_TITLE,"Элемент заголовка не появился",15);
        this.unlikeArticle();
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Элемент сохранения не найден",
                15);
        this.waitForElemAndClick(MENU_BTTN, "Элемент открытия бокового меню не найден", 10);
        this.waitForElemAndClick(WATCH_LIST, "Элемент открытия сохраненных статей не найден", 10);
    }

    @Step("Удаляем одну статью из списка и проверяем оставшуюся")
    public void deleteOneAndAssert()
    {
        this.waitForElemAndClick(UNLIKE_ARTICLE1,"Кнопка удаления одной статьи не найдена",15);
        this.waitForElemAndClick(MENU_BTTN, "Элемент открытия бокового меню не найден", 10);
        this.waitForElemAndClick(WATCH_LIST, "Элемент открытия сохраненных статей не найден", 10);
        this.assertElementPresent(SAVED_ARTICLE_HREF,"Ссылка на страницу сохраненной статьи не совпадает с необходимой");

    }

    public void waitForSecondArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(ARTICLE2_CONTAINS_TEXT, "Элемент не найден",
                15);
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Элемент сохранения не найден",
                15);
        this.waitForElemAndClick(NEW_LIST_ELEM,
                "New list не найден",
                10);
        this.waitForElemAndClick(CLOSE_BTTN,"Элемент X не найден", 10);
    }

    public void openSavedArticlesAndDeleteOne()
    {
        this.waitForElemAndClick(SAVE_ARTICLE_BTTN,
                "Кнопка сохраненных статей не найдена",
                10);
        this.waitForElemAndClick(ITEM_TITLE,
                "New list не найден",
                10);
        this.swipeElementLeft(ARTICLE1_CONTAINS_TEXT, "Статья не свайпается");

    }

    public void confirmSecondAndCheckTitle()
    {
        waitForElemAndClick(SECOND_TITLE,"Вторая статья не найдена", 10);
        waitForElem(SECOND_ARTICLE_TITLE,
                "Заголовок статьи не совпадает",
                15);
    }

}
