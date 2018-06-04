package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public boolean isPageLoaded()
    {
        return profileNavItem.isDisplayed();
    }
}
