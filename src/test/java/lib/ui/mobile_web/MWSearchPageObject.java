package lib.ui.mobile_web;

import lib.ui.searchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends searchPageObject {
        static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type='search']";
        SEARCH_CANCEL_BUTTON = "css:button.cancel";
        SEARCH_RESULT = "xpath://div[contains(@class,'page-summary')][contains(text(),'{SUBSTRING}')]";
    }
    public MWSearchPageObject(RemoteWebDriver driver)
        {
            super(driver);
        }



}

