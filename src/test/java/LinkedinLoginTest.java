import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest
{
    WebDriver webDriver;

    @BeforeMethod
    public void before() throws InterruptedException
    {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://www.linkedin.com/");

        sleep(2000);
    }

    @Test
    public void negativeLoginTest() throws InterruptedException
    {
        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(actualLoginPageTitle,
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong!");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed());
        linkedinLoginPage.login("skravchenko@adyax.com", "adyax11");
        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl,
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page URL is wrong");

        Assert.assertEquals(currentPageTitle,
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed");
    }


    @Test
    public void successfulLoginTest() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

//      Checking the title of the page is "LinkedIn: Log In or Sign Up"
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

//Checking URL is "https://www.linkedin.com/"
        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign in button isn't displayed!!!");
        linkedinLoginPage.login("skravchenko@adyax.com", "adyax111");

        sleep(3000);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong!");

        Assert.assertEquals(linkedinHomePage.getCurrentTitle(),
                "LinkedIn",
                "Title is wrong!");

        //String actualHomePageTitle = linkedinLoginPage.

        sleep(3000);
    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}