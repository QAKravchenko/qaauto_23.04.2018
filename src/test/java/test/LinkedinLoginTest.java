package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.*;
import util.GMailService;

import static java.lang.Thread.sleep;


public class LinkedinLoginTest extends LinkedinBaseTest
{
        @DataProvider
    public Object[][] validDataProvider()
    {
        return new Object[][]
        {
          {"skravchenko@adyax.com","adyax111"},
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

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) throws InterruptedException
    {
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);
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
        linkedinLoginPage.login(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login-Submit page Title is wrong!");

        Assert.assertEquals(linkedinLoginPage.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Login-Submit page URL is wrong!");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login page isn't loaded");
    }

    @Test(dataProvider = "invalidDataProviderLoginSubmitPage")
    public void negativeTestReturnedToLoginSubmitPage(String email, String password) throws InterruptedException
    {
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.loginSubmitPage(email, password);
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
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.loginSubmitPage(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinLoginSubmitPage.isErrorEmailMessageTextDisplayed(),
                "Please enter a valid email address.",
                "Email Error message isn't displayed!!!");
    }

    @Test(dataProvider = "invalidDataProviderLoginSubmitPageErrorMessageForPasswordField")
    public void negativeTestOnLoginSubmitPageErrorMessageForPasswordField(String email, String password) throws InterruptedException
    {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.loginSubmitPage(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinLoginSubmitPage.isErrorPasswordMessageTextDisplayed(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "Error Password message isn't displayed or wrong!!!");
    }

    @Test
    public void resetPassword() throws InterruptedException
    {
        LinkedinResetPasswordPage linkedinResetPasswordPage = linkedinLoginPage.forgotPasswordLink();
        sleep(3000);

        Assert.assertTrue(linkedinResetPasswordPage.isHeaderTextDisplayed(),
                "Header text isn't displayed");

        Assert.assertTrue(linkedinResetPasswordPage.isSubTitleDisplayed(),
                "Sub title text isn't displayed");

        Assert.assertTrue(linkedinResetPasswordPage.isLabelDisplayed(),
                "Label text isn't displayed");

        Assert.assertTrue(linkedinResetPasswordPage.isEmailOrPhoneFieldDisplayed(),
                "Email or Phone field isn't displayed");

        Assert.assertTrue(linkedinResetPasswordPage.isResetPasswordSubmitButtonDisplayed(),
                "Reset password submit button isn't displayed");


        LinkedinRequestPasswordPage linkedinRequestPasswordPage = linkedinResetPasswordPage.requestPasswordPage();
        sleep(3000);

        Assert.assertTrue(linkedinRequestPasswordPage.isTryDifferentEmailButonDisplayed(),
                "Try different email Button isn't displayed");

        Assert.assertTrue(linkedinRequestPasswordPage.isResendLinkButton(),
                "'Resend link' button isn't displayed");

        GMailService gMailService = new GMailService();
    }
}