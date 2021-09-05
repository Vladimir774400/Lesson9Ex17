package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.SaveArticles;
import lib.ui.SearchPageObject;
import lib.ui.android.AndroidSaveArticlePageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.ios.IosSaveArticlePageObject;
import lib.ui.ios.IosSearchPageObject;
import lib.ui.mobile_web.MWSaveArticlePageObject;
import lib.ui.mobile_web.MWSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SaveArticlePageObjectFactory {

    public static SaveArticles get(RemoteWebDriver driver)
    {
        if (Platform.getInstance().isAndroid())
        {
            return new AndroidSaveArticlePageObject((AppiumDriver) driver);
        }
        else if (Platform.getInstance().isIos())
        {
            return new IosSaveArticlePageObject((AppiumDriver) driver);
        }
        else
        {
            return new MWSaveArticlePageObject(driver);
        }
    }
}

