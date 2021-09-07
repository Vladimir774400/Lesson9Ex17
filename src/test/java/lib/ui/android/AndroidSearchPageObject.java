package lib.ui.android;

import lib.ui.searchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends searchPageObject
{
   static {
       SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
               SEARCH_INPUT = "xpath://*[contains(@text,'Search…')]";
               SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
               SEARCH_RESULT = "xpath://*[contains(@text,'{SUBSTRING}')]";
   }
    public AndroidSearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
