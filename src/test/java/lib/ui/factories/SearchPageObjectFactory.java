package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.searchPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.IosSearchPageObject;
import lib.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SearchPageObjectFactory {

    public static searchPageObject get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid())
        {
            return new AndroidSearchPageObject((AppiumDriver) driver);
        }
        else if (Platform.getInstance().isIos())
        {
            return new IosSearchPageObject((AppiumDriver) driver);
        }
        else
        {
            return new MWSearchPageObject(driver);
        }
    }
}
