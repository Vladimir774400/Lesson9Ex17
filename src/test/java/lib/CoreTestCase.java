package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CoreTestCase extends TestCase {

    protected RemoteWebDriver driver;

    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.openWikiWebPageForMobileWeb();
        System.out.println("- Запускаю тест.");
    }

    @Override
    protected void tearDown() throws Exception
    {
        System.out.println("- Завершение теста.");
        driver.quit();
        super.tearDown();
    }

    protected void openWikiWebPageForMobileWeb()
    {
        if (Platform.getInstance().isMW())
        {
            driver.get("https://en.m.wikipedia.org");
        }
        else
        {
            System.out.println("Method openWikiWebPageForMobileWeb() do nothing for platform "+ Platform.getInstance().getPlatformVar());
        }
    }
}
