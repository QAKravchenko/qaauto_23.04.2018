package test.NegativeLoginTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;

import static java.lang.Thread.sleep;

public class NegativeLoginEmptyLoginOrPasswordFieldsTest extends BaseTest
{
    @DataProvider
    public Object[][] invalidDataProviderLoginPage()
    {
        return new Object[][]
                {
                        {"skravchenko@adyax.com",""},
                        {"","adyax111"}
                };
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
}
