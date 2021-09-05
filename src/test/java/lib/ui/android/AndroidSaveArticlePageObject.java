package lib.ui.android;

import lib.ui.SaveArticles;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSaveArticlePageObject extends SaveArticles
{
    static {
        ARTICLE1_CONTAINS_TEXT = "xpath://*[contains(@text,'Java (programming language')]";
        ARTICLE2_CONTAINS_TEXT = "xpath://*[contains(@text,'Nikita Dzhigurda')]";
        CLOSE_BTTN = "xpath://*[@content-desc='Navigate up']";
        ONBOARDING_BTN = "id:org.wikipedia:id/onboarding_button";
        NAME_OF_LIST = "id:org.wikipedia:id/text_input";
        OK_BTTN = "id:android:id/button1";
        NEW_LIST_ELEM = "xpath://*[contains(@text,'New list')]";
        SAVE_ARTICLE_BTTN = "xpath://*[@content-desc='My lists']";
        ITEM_TITLE = "id:org.wikipedia:id/item_title";
        SECOND_TITLE = "id:org.wikipedia:id/page_list_item_title";
        SECOND_ARTICLE_TITLE = "xpath:///*[@resource-id='org.wikipedia:id/view_page_title_text' and @text='Nikita Dzhigurda']";

    }
    public AndroidSaveArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}