package lib.ui.mobile_web;

import lib.ui.saveArticles;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSaveArticlePageObject extends saveArticles {
    static {
                ARTICLE1_CONTAINS_TEXT = "css:body > div.mw-overlays-container > div > div.overlay-content > div > div.results > div > ul > li:nth-child(3) > a.title > div.wikidata-description";
                ARTICLE2_CONTAINS_TEXT = "css:body > div.mw-overlays-container > div > div.overlay-content > div > div.results > div > ul > li > a.title > h3";
                LOG_IN_BUTTON = "xpath:/html/body/div[1]/div/header/form/nav[1]/div/ul[2]/li/a";
                LOGIN_FIELD = "xpath:/html/body/div[1]/div/main/div[3]/div[1]/div/div[2]/form/div/div[3]/div/input";
                MENU_BTTN = "xpath:/html/body/div[1]/div/header/form/nav[1]/label[1]";
                PASS_FIELD = "xpath:/html/body/div[1]/div/main/div[3]/div[1]/div/div[2]/form/div/div[4]/div/input";
                CHECK_IN_BTTN = "xpath:/html/body/div[1]/div/main/div[3]/div[1]/div/div[2]/form/div/div[6]/div/button";
                FIND_BTTN = "xpath:/html/body/div[1]/div/header/form/nav[2]/div[1]/button";
                SEARCH_FIELD = "css:body > div.mw-overlays-container > div > div.overlay-header-container.header-container.header-chrome.position-fixed > div > div.overlay-title.search-header-view > form > input.search.mw-ui-background-icon-search";
                WATCH_LIST = "css:#p-personal > li:nth-child(2) > a";
                UNLIKE_ARTICLE1 = "css:#mw-content-text > ul > li:nth-child(1) > a.mw-ui-icon.mw-ui-icon-wikimedia-unStar-progressive.mw-ui-icon-element.watch-this-article.watched";
                SAVED_ARTICLE_HREF = "css:#mw-content-text > ul > li > a.title[href=\"/wiki/Nikita_Dzhigurda\"]";
                UNLIKE = "xpath:/html/body/div[1]/div/main/div[2]/nav/ul/li[3]/a[contains(text(),'Unwatch')]";
                UNLIKED_BUTTON = "xpath:/html/body/div[1]/div/main/div[2]/nav/ul/li[3]/a[contains(text(),'Watch')]";
                ARTICLE_TITLE = "css:#section_0";
    }
    public MWSaveArticlePageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}