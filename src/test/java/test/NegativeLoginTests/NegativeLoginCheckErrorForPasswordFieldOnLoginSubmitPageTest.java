package test.NegativeLoginTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginPage;
import page.LoginSubmitPage;
import test.BaseTest;

import static java.lang.Thread.sleep;

public class NegativeLoginCheckErrorForPasswordFieldOnLoginSubmitPageTest extends BaseTest
{
    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPageErrorMessageForPasswordField()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com", "adyax11"},
                        {"skravchenko@adyax.com", " dyax11"}
                };
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
}
