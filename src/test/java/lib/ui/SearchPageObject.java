package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends mainPageObject {
    protected static String
        SEARCH_INIT_ELEMENT,
        SEARCH_INPUT,
        SEARCH_CANCEL_BUTTON,
        SEARCH_RESULT;

    public SearchPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT.replace("{SUBSTRING}",substring);
    }
    public void searchInit()
    {
        this.waitForElemAndClick(SEARCH_INIT_ELEMENT, "НЕ МОГУ НАЙТИ ЭЛЕМЕНТ ПОЛЯ ВВОДА", 10);
        this.waitForElem(SEARCH_INPUT, "НЕ МОГУ НАЙТИ ПОЛЕ ВВОДА", 10);
    }
    public void typeSearchLine(String search_line)
    {
        this.waitForElemByAndSendKeys(SEARCH_INPUT, search_line, "Не могу найти вводимое слово в сторку поиска",15);
    }
    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElem(search_result_xpath, "Не могу найти результат поиска "+ substring, 10);
    }
    public void waitForSearchResultAndClick(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElemAndClick(search_result_xpath, "Не могу кликнуть результат поиска "+ substring, 10);
    }
}
