package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import page.LoginSubmitPage;

import static java.lang.Thread.sleep;


public class LoginTest extends BaseTest
{
        @DataProvider
    public Object[][] validDataProvider()
    {
        return new Object[][]
        {
          {"skravchenko@adyax.com","adyax11!"},
//          {"SKRAVCHENKO@ADYAX.COM","adyax111"}
        };
    }

    @DataProvider
    public Object[][] invalidDataProviderLoginPage()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com",""},
//                        {"","adyax111"},
//                        {"  ","adyax111"},
//                        {"skravchenko@adyaxcom","   "},
                };

    }

    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPage()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com","adyax11"},
//                        {"skravchenkoadyax.com","adyax111"},
//                        {"skravchenk@oadyaxcom","adyax111"},
//                        {"skravchenk@@oadyaxcom","adyax111"},
//                        {"skravchenk@oadyax..com","adyax111"},
//                        {"skravchenkoadyax.com","adyax11"},
//                        {"skravchenko@adyaxcom","ADYAX111"},
//                        {"skravchenkoadyaxcom","ADYAX111"}
                };
    }

    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPageErrorMessageForEmailField()
    {
        return new Object[][]
                {
                        {"skravchenkoadyax.com","adyax111"},
//                        {"skravchenk@oadyaxcom","adyax111"},
//                        {"skravchenk@@oadyaxcom","adyax111"},
//                        {"skravchenk@oadyax..com","adyax111"},
                };
    }

    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPageErrorMessageForPasswordField()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com","adyax11"},
//                        {"skravchenko@adyax.com"," dyax11"},
//                        {"skravchenko@adyax.com","ADYAX111"},
//                        {"skravchenko@adyax.com","ADYAX11 "}
                };
    }

    @DataProvider
    public Object[][] successfulLoginFromLoginSubmitPage()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com","adyax11"},
//                        {"skravchenko@adyax.com"," dyax11"},
//                        {"skravchenko@adyax.com","ADYAX111"},
//                        {"skravchenko@adyax.com","ADYAX11 "}
                };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException
    {
        Assert.assertEquals(loginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(loginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");

        HomePage linkedinHomePage = loginPage.login(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Home page URL is wrong!");

        Assert.assertEquals(linkedinHomePage.getCurrentTitle(),
                "LinkedIn",
                "Title is wrong!");

        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Homepage isn't loaded");
    }

    @Test(dataProvider = "invalidDataProviderLoginPage")
    public void negativeTestLoginPageEmptyEmailAndPasswordFields(String email, String password) throws InterruptedException
    {
        loginPage.login(email, password);
        sleep(3000);

        Assert.assertEquals(loginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(loginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page isn't loaded");
    }

    @Test(dataProvider = "invalidDataProviderLoginSubmitPage")
    public void negativeTestReturnedToLoginSubmitPage(String email, String password) throws InterruptedException
    {
        LoginSubmitPage linkedinLoginSubmitPage = loginPage.loginSubmitPage(email, password);
        sleep(3000);

        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login Submit page isn't opened");

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn",
                "Login Submit page Title is wrong!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit",
                "Login Submit page Url is wrong!!!");

        Assert.assertEquals(linkedinLoginSubmitPage.errorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text isn't displayed!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isSubmitEmailFieldDisplayed(),
                "Submit Email Field isn't displayed!!!");

        Assert.assertTrue(linkedinLoginSubmitPage.isSubmitPasswordFieldDisplayed(),
                "Submit Password Field isn't displayed!!!");

        if (linkedinLoginSubmitPage.isErrorEmailMessageDisplayed())
        {
            Assert.assertEquals(linkedinLoginSubmitPage.isErrorEmailMessageTextDisplayed(),
                    "Please enter a valid email address.",
                    "Email Error message isn't displayed!!!");
        }

        if (linkedinLoginSubmitPage.isErrorPasswordMessageDisplayed())
        {
            Assert.assertEquals(linkedinLoginSubmitPage.isErrorPasswordMessageTextDisplayed(),
                    "Hmm, that's not the right password. Please try again or request a new one.",
                    "Error Password message isn't displayed or wrong!!!");
        }

            Assert.assertTrue(linkedinLoginSubmitPage.isSignInButtonDisplayed(),
                "Sign in Button isn't displayed!!!");
    }

    @Test(dataProvider = "invalidDataProviderLoginSubmitPageErrorMessageForEmailField")
    public void negativeTestOnLoginSubmitPageErrorMessageForEmailField(String email, String password) throws InterruptedException
    {
        LoginSubmitPage linkedinLoginSubmitPage = loginPage.loginSubmitPage(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinLoginSubmitPage.isErrorEmailMessageTextDisplayed(),
                "Please enter a valid email address.",
                "Email Error message isn't displayed!!!");
    }

    @Test(dataProvider = "invalidDataProviderLoginSubmitPageErrorMessageForPasswordField")
    public void negativeTestOnLoginSubmitPageErrorMessageForPasswordField(String email, String password) throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(webDriver);

        LoginSubmitPage loginSubmitPage = loginPage.loginSubmitPage(email, password);
        sleep(3000);

        Assert.assertEquals(loginSubmitPage.isErrorPasswordMessageTextDisplayed(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Error Password message isn't displayed or wrong!!!");
    }

    @Test(dataProvider = "successfulLoginFromLoginSubmitPage")
    public void successfulLoginFromLoginSubmitPage(String email, String password) throws InterruptedException
    {
        LoginPage loginPage = new LoginPage(webDriver);

        LoginSubmitPage loginSubmitPage = loginPage.loginSubmitPage(email, password);
        sleep(3000);

        loginSubmitPage.login();
        sleep(3000);
    }
}