package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultsPage;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchTest extends BaseTest
{
    @Test
    public void basicSearchTest() throws InterruptedException
    {
        String searchTerm = "HR";

        HomePage homePage = loginPage.login(userEmail, newUserPassword);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home Page is not loaded.");
        sleep(2000);

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        sleep(2000);
        Assert.assertTrue(searchResultsPage.isPageLoaded(),
                "SearchResults Page is not loaded.");


        List<String> searchResultsList = searchResultsPage.getSearchResults();
        sleep(2000);
        Assert.assertEquals(searchResultsList.size(), 10,
                "Count of search result items is wrong.");

        for (String searchResult:searchResultsList)
        {
            Assert.assertTrue(searchResult.contains(searchTerm),
                "Searchterm "+searchTerm+" was not found in: \n"+searchResult);
        }
    }
}