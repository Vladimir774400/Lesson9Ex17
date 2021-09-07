package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;

public class CoreTestCase {

    protected RemoteWebDriver driver;

    @Before
    @Step("Запускаю драйвер и сессию")
    public void setUp() throws Exception
    {
        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.openWikiWebPageForMobileWeb();
        System.out.println("- Запускаю тест.");
    }

    @After
    @Step("Завершаю драйвер и сессию")
    public void tearDown()
    {
        System.out.println("- Завершение теста.");
        driver.quit();
    }

    @Step("Метод открывает страницу wiki для mobile_web")
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

    private void createAllurePropertyFile()
    {
        String path = System.getProperty("allure.results.directory");
        try
        {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment",Platform.getInstance().getPlatformVar());
            props.store(fos,"See /wiki/Environvent");
            fos.close();
        }
        catch (Exception e)
        {
            System.err.println("IO problem when writing allure properties file");
            e.printStackTrace();
        }
    }

}
