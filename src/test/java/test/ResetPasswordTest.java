package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class ResetPasswordTest extends BaseTest
{
    String userEmail = "skravchenko@adyax.com";
    String newUserPassword = "P@ssword2";

    @Test
    public void successfullPaswordResetTest() throws InterruptedException
    {
      ResetPasswordPage resetPasswordPage = loginPage.clickOnForgotPasswordLink();
       Assert.assertTrue(resetPasswordPage.isPageLoaded(),
                "Request Password Reset Page isn't loaded");

      PleaseCheckYourEmailPage pleaseCheckYourEmailPage = resetPasswordPage.submitUserEmail(userEmail);
       Assert.assertTrue(pleaseCheckYourEmailPage.isPageLoaded(),
                "Please Check Your Email Page isn't loaded");

      ResetYourPasswordPage resetYourPasswordPage = pleaseCheckYourEmailPage.navigateToLinkFromEmail();
       Assert.assertTrue(resetYourPasswordPage.isPageLoaded(),
                "Reset Your Password Page isn't loaded");

      SuccessfullyResetYourPasswordPage successfullyResetYourPasswordPage = resetYourPasswordPage.submitNewPassword(newUserPassword);
       Assert.assertTrue(successfullyResetYourPasswordPage.isPageLoaded(),
                "Successfully Reset Your Password Page isn't loaded");

      HomePage homePage = successfullyResetYourPasswordPage.clickOnGoToHomepageButton();
       Assert.assertTrue(homePage.isPageLoaded(),
                "Homepage isn't loaded");

       webDriver.get("https://www.linkedin.com/m/logout/");
       sleep(5000);

        loginPage.successfulLoginWithNewPassword(userEmail, newUserPassword);
    }
}
