package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class SearchResultsPage extends BasePage
{
    @FindBy(xpath = "//h3[contains(@class,'search-results__total')]")
    private WebElement searchResultsCount;

    public SearchResultsPage(WebDriver webDriver)
    {
        super(webDriver);
//        waitUntilElementIsClickable(searchResultsCount, 10);
    }

    public boolean isPageLoaded()
    {
        return searchResultsCount.isDisplayed();
    }

    public List<String> getSearchResults()
    {
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//ul[@class='search-results__list list-style-none']//li[@class='search-result search-result__occluded-item ember-view']"));
        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults)
        {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("HR"))
            {
                System.out.println("Search Term found!");
            }
            System.out.println(searchResultText);
        }
        return null;
    }
}