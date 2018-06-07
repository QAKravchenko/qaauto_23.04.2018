package test.NegativeLoginTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LoginSubmitPage;
import test.BaseTest;

import static java.lang.Thread.sleep;

public class NegativeLoginCheckErrorForEmailFieldOnLoginSubmitPageTest extends BaseTest
{
    @DataProvider
    public Object[][] invalidDataProviderLoginSubmitPageErrorMessageForEmailField()
    {
        return new Object[][]
                {
                        {"skravchenkoadyax.com","adyax111"},
                        {"skravchenk@oadyaxcom","adyax111"}
                };
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
}
