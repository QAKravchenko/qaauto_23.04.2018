package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage
{
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy (xpath ="//div[@class='nav-search-typeahead']//input[@type='text']")
    private WebElement searchField;



    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public boolean isPageLoaded()
    {
        return profileNavItem.isDisplayed();
    }

    public SearchResultsPage search(String searchTerm)
    {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver, SearchResultsPage.class);
    }
}
