package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage
{
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl()
    {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle()
    {
        return webDriver.getTitle();
    }

    abstract boolean isPageLoaded();
}
