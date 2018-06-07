package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Homepage of Linkedin
 */
public class HomePage extends BasePage
{
    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavItem;

    @FindBy (xpath ="//div[@class='nav-search-typeahead']//input[@type='text']")
    private WebElement searchField;


    /**
     * Constructor of HomePage
     * @param webDriver - webDriver instance
     */
    public HomePage(WebDriver webDriver)
    {
        super(webDriver);
    }

    /**
     * Method for checking of loading "Profile icon" element
     * @return - returning of loaded element
     */
    public boolean isPageLoaded()
    {
        return profileNavItem.isDisplayed();
    }

    /**
     * Method for searching on Homepage
     * @param searchTerm - particular word for searching
     * @return - returning Pagefactory Search results page with found results
     */
    public SearchResultsPage search(String searchTerm)
    {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return PageFactory.initElements(webDriver, SearchResultsPage.class);
    }
}
