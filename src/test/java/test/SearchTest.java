package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchResultsPage;

import java.util.List;

public class SearchTest extends BaseTest
{
    @Test
    public void basicSearchTest() throws InterruptedException
    {
        String searchTerm = "HR";

        HomePage homePage = loginPage.login(userEmail, newUserPassword);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home Page is not loaded.");


        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(),
                "SearchResults Page is not loaded.");


        List<String> searchResultsList = searchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 10,
                "Count of search result items is wrong.");
        System.out.println(searchResultsList.size());

        for (String searchResult : searchResultsList)
        {
            Assert.assertTrue(searchResult.contains(searchTerm),
                "Searchterm "+searchTerm+" was not found in: \n"+searchResult);
        }
    }
}