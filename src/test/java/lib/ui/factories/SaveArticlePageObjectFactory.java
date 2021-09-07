package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import lib.ui.saveArticles;
import lib.ui.android.AndroidSaveArticlePageObject;
import lib.ui.ios.IosSaveArticlePageObject;
import lib.ui.mobile_web.MWSaveArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SaveArticlePageObjectFactory {

    public static saveArticles get(RemoteWebDriver driver)
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

