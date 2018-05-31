package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkedinHomePage extends LinkedinBasePage
{
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    public LinkedinHomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public boolean isPageLoaded()
    {
        return profileNavItem.isDisplayed();
    }
}
