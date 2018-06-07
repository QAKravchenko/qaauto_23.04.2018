package test.NegativeLoginTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginSubmitPage;
import test.BaseTest;

import static java.lang.Thread.sleep;

public class NegativeLoginInvalidLoginOrPasswordTest extends BaseTest
{
    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPage()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com","adyax11"},
                        {"skravchenkoadyax.com",newUserPassword}
                };
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
}
