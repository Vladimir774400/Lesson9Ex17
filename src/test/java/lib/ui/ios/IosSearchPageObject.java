package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IosSearchPageObject extends SearchPageObject
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