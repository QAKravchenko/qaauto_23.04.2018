import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] validDataProvider()
    {
        return new Object[][]
        {
          {"skravchenko@adyax.com","adyax111"},
          {"SKRAVCHENKO@ADYAX.COM","adyax111"}
        };
    }

    @Test
    public void negativeReturnedToLoginSubmitPage() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("skravchenko@adyax.com", "adyax11");
        sleep(3000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login Submit page Title is wrong!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login Submit page Url is wrong!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login submit page isn't loaded");

        Assert.assertEquals(linkedinLoginSubmitPage.errorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text isn't displayed!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isSubmitEmailFieldDisplayed(),
                "Submit Email Field isn't displayed!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isSubmitPasswordFieldDisplayed(),
                "Submit Password Field isn't displayed!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.isErrorPasswordMessageDisplayed(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Error Password message isn't displayed or wrong!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isSignInButtonDisplayed(),
                "Sign in Button isn't displayed!!!");
    }


    @Test
    public void negativeLoginTestEmptyPasswordField() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("skravchenko@adyax.com", "");
        sleep(1000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");
    }


    @Test
    public void negativeLoginTestEmptyEmailField() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("", "adyax111");
        sleep(1000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");
    }


    @Test
    public void negativeLoginTestWrongEmailAndPassword() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("skravchenkoadyax.com", "adyax");
        sleep(1000);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login Submit page Title is wrong!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login Submit page Url is wrong!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.isErrorEmailMessageDisplayed(),
                "Please enter a valid email address.",
                "Email Error message isn't displayed!!!");
    }


    @Test
    public void negativeLoginTestEmptyEmailAndPasswordFields() throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        linkedinLoginPage.login("", "");
        sleep(1000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");
    }


    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "Sign in button isn't displayed!!!");
        linkedinLoginPage.login(email, password);

        sleep(3000);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong!");

        Assert.assertEquals(linkedinHomePage.getCurrentTitle(),
                "LinkedIn",
                "Title is wrong!");

        sleep(3000);
    }


    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}