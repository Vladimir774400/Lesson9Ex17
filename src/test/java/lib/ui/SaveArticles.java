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
        this.waitForElemAndClick(ARTICLE1_CONTAINS_TEXT, "������� � ���������� ������ ������ �� ������",
                15);
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "������� ���������� �� ������",
                15);
        this.waitForElemAndClick(ONBOARDING_BTN,
                "������ ���������� Got It �� �������",
                10);
        this.waitForElemAndClear( NAME_OF_LIST,
                "������ '��� �����' �� ������������ � ������� 5 ������",
                5);
        this.waitForElemByAndSendKeys(
                NAME_OF_LIST,
                "New list",
                "������ '��� �����' �� ������������ � ������� 5 ������",
                5);
        this.waitForElemAndClick(OK_BTTN,
                "������� ������ �� �� ������",
                15);
        this.waitForElemAndClick(CLOSE_BTTN,"������� X �� ������", 10);
    }

    public void loginInWikiForMW()
    {
        this.waitForElemAndClick(MENU_BTTN, "������� �������� �������� ���� �� ������", 10);
        this.waitForElemAndClick(LOG_IN_BUTTON, "������ ����������� �� �������", 10);
        this.waitForElemByAndSendKeys(LOGIN_FIELD,"TestApium","�� ���� ����� ���� ����� ������",10);
        this.waitForElemByAndSendKeys(PASS_FIELD,"testappium","�� ���� ����� ���� ����� ������",10);
        this.waitForElemAndClick(CHECK_IN_BTTN,"�� ���� ����� ������ ������", 10);

    }

    public Boolean isElementPresent(String locator)
    {
        return getAmountOfElem(locator)>0;
    }

    public void unlikeArticle()
    {
        if (this.isElementPresent(UNLIKE)) {
           this.waitForElemAndClick(UNLIKE,"�� ���� �������� �� ������",20);
        }
        else
        {
            this.waitForElem(UNLIKED_BUTTON, "������ �� ����������� ������ �� �������",15);
        }
    }

    public void saveTwoArticlesForMW()
    {
        this.waitForElemAndClick(ARTICLE1_CONTAINS_TEXT, "������� � ���������� ������ ������ �� ������",
                15);
        this.waitForElem(ARTICLE_TITLE,"������� ��������� �� ��������",15);
        this.unlikeArticle();
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "������� ���������� �� ������",
                15);
        this.waitForElemAndClick(FIND_BTTN,"�� ���� ����� ������ ������",10);
        this.waitForElemByAndSendKeys(SEARCH_FIELD,"Dzigurda", "�� ���� ����� ���� ������", 17);
        this.waitForElemAndClick(ARTICLE2_CONTAINS_TEXT,"�� ���� ����� ������ ������", 10);
        this.waitForElem(ARTICLE_TITLE,"������� ��������� �� ��������",15);
        this.unlikeArticle();
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "������� ���������� �� ������",
                15);
        this.waitForElemAndClick(MENU_BTTN, "������� �������� �������� ���� �� ������", 10);
        this.waitForElemAndClick(WATCH_LIST, "������� �������� ����������� ������ �� ������", 10);
    }

    public void deleteOneAndAssert()
    {
        this.waitForElemAndClick(UNLIKE_ARTICLE1,"������ �������� ����� ������ �� �������",15);
        this.waitForElemAndClick(MENU_BTTN, "������� �������� �������� ���� �� ������", 10);
        this.waitForElemAndClick(WATCH_LIST, "������� �������� ����������� ������ �� ������", 10);
        this.assertElementPresent(SAVED_ARTICLE_HREF,"������ �� �������� ����������� ������ �� ��������� � �����������");

    }

    public void waitForSecondArticlePresentSaveAndExitToMainPage()
    {
        this.waitForElemAndClick(ARTICLE2_CONTAINS_TEXT, "������� �� ������",
                15);
        this.waitForElemAndClick(UNLIKED_BUTTON,
                "������� ���������� �� ������",
                15);
        this.waitForElemAndClick(NEW_LIST_ELEM,
                "New list �� ������",
                10);
        this.waitForElemAndClick(CLOSE_BTTN,"������� X �� ������", 10);
    }

    public void openSavedArticlesAndDeleteOne()
    {
        this.waitForElemAndClick(SAVE_ARTICLE_BTTN,
                "������ ����������� ������ �� �������",
                10);
        this.waitForElemAndClick(ITEM_TITLE,
                "New list �� ������",
                10);
        this.swipeElementLeft(ARTICLE1_CONTAINS_TEXT, "������ �� ����������");

    }

    public void confirmSecondAndCheckTitle()
    {
        waitForElemAndClick(SECOND_TITLE,"������ ������ �� �������", 10);
        waitForElem(SECOND_ARTICLE_TITLE,
                "��������� ������ �� ���������",
                15);
    }

}
