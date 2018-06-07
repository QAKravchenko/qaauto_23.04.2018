package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

/**
 * Base Page with methods which will be used in all pages, if extends BasePage will be mentioned
 */
public abstract class BasePage
{
    protected WebDriver webDriver;
    protected static GMailService gMailService = new GMailService();

    /**
     * Constructor of BasePage
     * @param webDriver - webDriver instance
     */
    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    /**
     * Method to get current URL of the page
     * @return of got URL
     */
    public String getCurrentUrl()
    {
        return webDriver.getCurrentUrl();
    }

    /**
     * Method to get current title of the page
     * @return of got title
     */
    public String getCurrentTitle()
    {
        return webDriver.getTitle();
    }

    /**
     * Method is used in all child pages to mention any element loaded on a page
     * @return - returning of loaded element
     */
    abstract boolean isPageLoaded();

    /**
     * Method to ensure that element is clickable on a page
     * @param webElement - any element on a page
     * @param timeOutInSeconds - time in seconds for element waiting
     * @return - returning of clickable element
     */
    public WebElement waitUntilElementIsClickable (WebElement webElement, int timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable((By) webElement));
        return webElement;
    }

    /**
     * Method to ensure that element is visible on a page
     * @param webElement - any element on a page
     * @param timeOutInSeconds - time in seconds for element waiting
     * @return - returning of visible element
     */
    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }
}
