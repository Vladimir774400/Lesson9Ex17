package lib.ui.ios;

import lib.ui.searchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosSearchPageObject extends searchPageObject
    {
        static {
        SEARCH_INIT_ELEMENT = "//*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "//*[contains(@text,'Search…')]";
        SEARCH_CANCEL_BUTTON = "org.wikipedia:id/search_close_btn";
        SEARCH_RESULT = "//*[contains(@text,'{SUBSTRING}')]";
    }
    public IosSearchPageObject(RemoteWebDriver driver)
        {
            super(driver);
        }
    }