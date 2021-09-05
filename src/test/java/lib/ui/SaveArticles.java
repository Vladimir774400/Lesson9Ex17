package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SaveArticles extends mainPageObject{

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



    public SaveArticles(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void waitForFirstArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(ARTICLE1_CONTAINS_TEXT, "Ёлемент в выпадающем списке поиска не найден",
                15);
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Ёлемент сохранени€ не найден",
                15);
        this.waitForElemAndClick(ONBOARDING_BTN,
                " нопка онбординга Got It не найдена",
                10);
        this.waitForElemAndClear( NAME_OF_LIST,
                "ќбьект '»м€ листа' не отображаетс€ в течении 5 секунд",
                5);
        this.waitForElemByAndSendKeys(
                NAME_OF_LIST,
                "New list",
                "ќбьект '»м€ листа' не отображаетс€ в течении 5 секунд",
                5);
        this.waitForElemAndClick(OK_BTTN,
                "Ёлемент кнопки ќ  не найден",
                15);
        this.waitForElemAndClick(CLOSE_BTTN,"Ёлемент X не найден", 10);
    }

    public void loginInWikiForMW()
    {
        this.waitForElemAndClick(MENU_BTTN, "Ёлемент открыти€ бокового меню не найден", 10);
        this.waitForElemAndClick(LOG_IN_BUTTON, " нопка авторизации не найдена", 10);
        this.waitForElemByAndSendKeys(LOGIN_FIELD,"TestApium","Ќе могу найти поле ввода логина",10);
        this.waitForElemByAndSendKeys(PASS_FIELD,"testappium","Ќе могу найти поле ввода парол€",10);
        this.waitForElemAndClick(CHECK_IN_BTTN,"Ќе могу найти кнопку логина", 10);

    }

    public Boolean isElementPresent(String locator)
    {
        return getAmountOfElem(locator)>0;
    }

    public void unlikeArticle()
    {
        if (this.isElementPresent(UNLIKE)) {
           this.waitForElemAndClick(UNLIKE,"Ќе могу кликнуть по кнопке",20);
        }
        else
        {
            this.waitForElem(UNLIKED_BUTTON, " нопка не сохраненной статьи не найдена",15);
        }
    }

    public void saveTwoArticlesForMW()
    {
        this.waitForElemAndClick(ARTICLE1_CONTAINS_TEXT, "Ёлемент в выпадающем списке поиска не найден",
                15);
        this.waitForElem(ARTICLE_TITLE,"Ёлемент заголовка не по€вилс€",15);
        this.unlikeArticle();
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Ёлемент сохранени€ не найден",
                15);
        this.waitForElemAndClick(FIND_BTTN,"Ќе могу найти кнопку поиска",10);
        this.waitForElemByAndSendKeys(SEARCH_FIELD,"Dzigurda", "Ќе могу найти поле поиска", 17);
        this.waitForElemAndClick(ARTICLE2_CONTAINS_TEXT,"Ќе могу найти вторую статью", 10);
        this.waitForElem(ARTICLE_TITLE,"Ёлемент заголовка не по€вилс€",15);
        this.unlikeArticle();
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Ёлемент сохранени€ не найден",
                15);
        this.waitForElemAndClick(MENU_BTTN, "Ёлемент открыти€ бокового меню не найден", 10);
        this.waitForElemAndClick(WATCH_LIST, "Ёлемент открыти€ сохраненных статей не найден", 10);
    }

    public void deleteOneAndAssert()
    {
        this.waitForElemAndClick(UNLIKE_ARTICLE1," нопка удалени€ одной статьи не найдена",15);
        this.waitForElemAndClick(MENU_BTTN, "Ёлемент открыти€ бокового меню не найден", 10);
        this.waitForElemAndClick(WATCH_LIST, "Ёлемент открыти€ сохраненных статей не найден", 10);
        this.assertElementPresent(SAVED_ARTICLE_HREF,"—сылка на страницу сохраненной статьи не совпадает с необходимой");

    }

    public void waitForSecondArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(ARTICLE2_CONTAINS_TEXT, "Ёлемент не найден",
                15);
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "Ёлемент сохранени€ не найден",
                15);
        this.waitForElemAndClick(NEW_LIST_ELEM,
                "New list не найден",
                10);
        this.waitForElemAndClick(CLOSE_BTTN,"Ёлемент X не найден", 10);
    }

    public void openSavedArticlesAndDeleteOne()
    {
        this.waitForElemAndClick(SAVE_ARTICLE_BTTN,
                " нопка сохраненных статей не найдена",
                10);
        this.waitForElemAndClick(ITEM_TITLE,
                "New list не найден",
                10);
        this.swipeElementLeft(ARTICLE1_CONTAINS_TEXT, "—тать€ не свайпаетс€");

    }

    public void confirmSecondAndCheckTitle()
    {
        waitForElemAndClick(SECOND_TITLE,"¬тора€ стать€ не найдена", 10);
        waitForElem(SECOND_ARTICLE_TITLE,
                "«аголовок статьи не совпадает",
                15);
    }

}
