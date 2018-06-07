package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


/**
 * Search results page
 */
public class SearchResultsPage extends BasePage
{
    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//li[contains(@class,'search-result search-result__occluded')]")
    private List<WebElement> searchResultElements;

    /**
     * Constructor of "Search results" page
     * @param webDriver - webdriver instance
     */
    public SearchResultsPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    /**
     * Method for waiting of element quantity of found results
     * @return - returning of quantity of found results
     */
    public boolean isPageLoaded()
    {
        waitUntilElementIsVisible(searchResultsCount, 10);
        return searchResultsCount.isDisplayed();
    }

    /**
     * Method for getting list of search results
     * @return - returning list of search results
     */
    public List<String> getSearchResults()
    {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements)
        {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}