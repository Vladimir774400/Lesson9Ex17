package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class mainPageObject {
    protected RemoteWebDriver driver;
    public mainPageObject (RemoteWebDriver driver)
    {
        this.driver = driver;
    }

    //Методы

    public void prepareScreenOrientation ()
    {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver =(AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
        else {
            System.out.println("Method prepareScreenOrientation () does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }
    }

    public void assertElementPresent (String locator, String error_message)
    {
        By by = this.getLocatorByString(locator);
        Assert.assertTrue(error_message, driver.findElements(by).size()>0);
    }

    public WebElement waitForElem(String locator, String error_message, long timeOutInSec)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }



    public WebElement waitForElemAndClick(String locator, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(locator, error_message, timeOutInSec);
        element.click();
        return element;
    }



    public WebElement waitForElemByAndSendKeys(String locator, String value, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(locator, error_message, timeOutInSec);
        element.sendKeys(value);
        return element;
    }



    public WebElement waitForElemAndClear(String locator, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(locator, error_message, timeOutInSec);
        element.clear();
        return element;
    }



    public boolean waitForElemNotPresent(String locator, String error_message, long timeOutInSec)
    {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSec);
        wait.withMessage(error_message + "/n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }



    public WebElement assertElementHasText(String locator, String value, String assert_error_message, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(locator, error_message, timeOutInSec);
        String textValue = element.getAttribute("text");
        Assert.assertEquals(assert_error_message,
                value,
                textValue);
        return element;
    }

    public WebElement assertElementContainsText(String locator, String value,  String assert_error_message, String error_message, long timeOutInSec)
    {
        WebElement element = waitForElem(locator, error_message, timeOutInSec);
        String textValue = element.getAttribute("text");
        Assert.assertTrue(assert_error_message,textValue.contains(value));
        return element;
    }

    public void swipeUp(int timeOfSwipe)
    {
        if (driver instanceof AppiumDriver) {
            TouchAction action = new TouchAction((AppiumDriver)driver);
            Dimension size = driver.manage().window().getSize();
            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);
            action
                    .press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(timeOfSwipe)))
                    .moveTo(PointOption.point(x, end_y))
                    .release()
                    .perform();
        }
        else {
            System.out.println("Method swipeUp() does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }
    }

    public void swipeUpFast()
    {
        swipeUp(200);
    }

    public void swipeUpTillFindElem(String locator, String error_message, int max_swipes)
    {
        By by = this.getLocatorByString(locator);
        int alreadySwiped = 0;
        while (driver.findElements(by).size()==0)
        {
            if (alreadySwiped>max_swipes)
            {
                waitForElem(locator,"Не могу найти элемента в процессе скролла вниз. \n" + error_message , 0);
                return;
            }

            swipeUpFast();
            ++alreadySwiped;
        }
    }

    public void swipeElementLeft(String locator, String error_message)
    {
        if (driver instanceof AppiumDriver) {
            AppiumDriver driver =(AppiumDriver) this.driver;
            WebElement element = waitForElem(locator, error_message, 10);
            Dimension size = driver.manage().window().getSize();
            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle = (upper_y + lower_y) / 2;
            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(right_x, middle))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(400)))
                    .moveTo(PointOption.point(left_x, middle))
                    .release()
                    .perform();
        }
        else {
            System.out.println("Method swipeElementLeft () does nothing for platform "+ Platform.getInstance().getPlatformVar());
        }
    }

    public int getAmountOfElem(String locator)
    {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();

    }

    public void assertElemNotPresent (String locator, String error_message)
    {
        int amount_of_elements = getAmountOfElem(locator);
        if (amount_of_elements > 0){
            String default_message = "Элемент '"+ locator + "' не появился";
            throw new AssertionError(default_message + "" + error_message);
        }
    }


    public String waitForElementAndGetAttribute (String locator, String attribute, String error_message, long timeOut)
    {
        WebElement element = waitForElem(locator, error_message, timeOut);
        return  element.getAttribute(attribute);
    }

    private By getLocatorByString (String locator_with_type)
    {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"),2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath"))
        {
            return By.xpath(locator);
        }
        else if (by_type.equals("id"))
        {
            return By.id(locator);
        }
        else if (by_type.equals("css"))
        {
            return By.cssSelector(locator);
        }
        else
        {
            throw new IllegalArgumentException("Cannot get type of locator. Locator: "+locator_with_type);
        }

    }
}
