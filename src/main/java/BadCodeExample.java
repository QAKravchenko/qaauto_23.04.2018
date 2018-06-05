import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class BadCodeExample
{
    public static void main(String args[]) throws InterruptedException
    {
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.google.com/");

        WebElement searchField = webDriver.findElement(By.id("lst-ib"));
        searchField.sendKeys("Selenium");
        sleep (2000);

        //Two variants of page opening

        // First variant. By clicking on button
         WebElement searchButton = webDriver.findElement(By.xpath("//input[@type='button' and contains(@value,'Google')]"));
        searchButton.click();

        //Second variant. By pressing on "Enter" button on keyboard
        //searchField.sendKeys(Keys.ENTER);

/*        for (int i=1; i<=10; i++)
        {
            WebElement searchResult = webDriver.findElement(By.xpath("//div[@class='srg']/div[" + i + "]"));
            String searchResultText = searchResult.getText();
            System.out.println(searchResult.getText());
            if (searchResultText.contains("Selenium"))
            {
                System.out.println("SearchTerm found!!");
            }
            System.out.println(searchResultText);
        }*/



        //If 10 wasn't displayed according to this !!!System.out.println(searchResultsnew.size());!!! need to add sleep (3000); after !!!searchField.sendKeys(Keys.ENTER);!!!
        //Founding all search results blocks
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//ul[@class='search-results__list list-style-none']//li[@class='search-result search-result__occluded-item ember-view']"));
        System.out.println(searchResults.size());

        for (WebElement searchResult : searchResults)
        {
            String searchResultText = searchResult.getText();
            if (searchResultText.contains("Selenium"))
            {
                System.out.println("Search Term found!");
            }
            System.out.println(searchResultText);
        }


/*
        //Founding each search result block and printing out the text
        //First block of search results
        WebElement searchResults1 = webDriver.findElement(By.xpath("//div[@class='srg']/div[1]"));
        String firstMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[1]/descendant::a[1]")).getText();
        System.out.println(firstMainLink);
        String firstTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[1]//span[@class='st']")).getText();
        System.out.println(firstTextBlock);

        if (searchResults1.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Second block of search results
        WebElement searchResults2 = webDriver.findElement(By.xpath("//div[@class='srg']/div[2]"));
        String secondMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[2]/descendant::a[1]")).getText();
        System.out.println(secondMainLink);
        String secondTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[2]//span[@class='st']")).getText();
        System.out.println(secondTextBlock);

        if (searchResults2.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Third block of search results
        WebElement searchResults3 = webDriver.findElement(By.xpath("//div[@class='srg']/div[3]"));
        String thirdMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[3]/descendant::a[1]")).getText();
        System.out.println(thirdMainLink);
        String thirdTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[3]//span[@class='st']")).getText();
        System.out.println(thirdTextBlock);

        if (searchResults3.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Fourth block of search results
        WebElement searchResults4 = webDriver.findElement(By.xpath("//div[@class='srg']/div[4]"));
        String fourthMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[4]/descendant::a[1]")).getText();
        System.out.println(fourthMainLink);
        String fourthTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[4]//span[@class='st']")).getText();
        System.out.println(fourthTextBlock);

        if (searchResults4.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Fifth block of search results
        WebElement searchResults5 = webDriver.findElement(By.xpath("//div[@class='srg']/div[5]"));
        String fifthMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[5]/descendant::a[1]")).getText();
        System.out.println(fifthMainLink);
        String fifthTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[5]//span[@class='st']")).getText();
        System.out.println(fifthTextBlock);

        if (searchResults5.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Sixth block of search results
        WebElement searchResults6 = webDriver.findElement(By.xpath("//div[@class='srg']/div[6]"));
        String sixthMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[6]/descendant::a[1]")).getText();
        System.out.println(sixthMainLink);
        String sixthTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[6]//span[@class='st']")).getText();
        System.out.println(sixthTextBlock);

        if (searchResults6.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Seventh block of search results
        WebElement searchResults7 = webDriver.findElement(By.xpath("//div[@class='srg']/div[7]"));
        String seventhMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[7]/descendant::a[1]")).getText();
        System.out.println(seventhMainLink);
        String seventhTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[7]//span[@class='st']")).getText();
        System.out.println(seventhTextBlock);

        if (searchResults7.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Eighth block of search results
        WebElement searchResults8 = webDriver.findElement(By.xpath("//div[@class='srg']/div[8]"));
        String eighthMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[8]/descendant::a[1]")).getText();
        System.out.println(eighthMainLink);
        String eighthTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[8]//span[@class='st']")).getText();
        System.out.println(eighthTextBlock);

        if (searchResults8.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();

        //Ninth block of search results
        WebElement searchResults9 = webDriver.findElement(By.xpath("//div[@class='srg']/div[9]"));
        String ninthMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[9]/descendant::a[1]")).getText();
        System.out.println(ninthMainLink);
        String ninthTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[9]//span[@class='st']")).getText();
        System.out.println(ninthTextBlock);

        if (searchResults9.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();


        //Tenth block of search results
        WebElement searchResults10 = webDriver.findElement(By.xpath("//div[@class='srg']/div[10]"));
        String tenthMainLink = webDriver.findElement(By.xpath("//div[@class='srg']/div[10]/descendant::a[1]")).getText();
        System.out.println(tenthMainLink);
        String tenthTextBlock = webDriver.findElement(By.xpath("//div[@class='srg']/div[10]//span[@class='st']")).getText();
        System.out.println(tenthTextBlock);

        if (searchResults10.getText().contains("Selenium"))
        {
            System.out.println("Search term found in result");
        }
        else
            System.out.println("Search term was not found in result");

        System.out.println();
*/

        sleep(2000);

        webDriver.close();
    }
}
