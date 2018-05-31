package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinRequestPasswordResetPage;

public class LinkedinResetPasswordTest extends LinkedinBaseTest
{
    @Test
    public void successfullPaswordResetTest()
    {
      String userEmail = "skravchenko@adyax.com";
      String newUserPassword = "P@ssword1";

      LinkedinRequestPasswordResetPage linkedinRequestPasswordResetPage = linkedinLoginPage.clickOnForgotPasswordLink();
      Assert.assertTrue(linkedinRequestPasswordResetPage.isPageLoaded(),
                "RequestPasswordResetPage isn't loaded");

      LinkedinRequestPasswordResetSubmitPage linkedinRequestPasswordResetSubmitPage = linkedinRequestPasswordResetPage.submitUserEmail(userEmail);
      Assert.assertTrue(linkedinRequestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmitPage isn't loaded");

      LinkedinSetNewPasswordPage linkedinSetNewPasswordPage = linkedinRequestPasswordResetSubmitPage.navigateToLinkFromEmail();
      Assert.assertTrue(linkedinSetNewPasswordPage.isPageLoaded(),
                "SetNewPasswordPage isn't loaded");

      LinkedinSuccessfulPasswordResetPage linkedinSuccessfulPasswordResetPage = linkedinSetNewPasswordPage.submitNewPassword(newUserPassword);
        Assert.assertTrue(linkedinSuccessfulPasswordResetPage.isPageLoaded(),
                "SuccessfulPasswordResetPage isn't loaded");

       LinkedinHomePage linkedinHomePage = linkedinSuccessfulPasswordResetPage.clickOnGoToHomeButton();
        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Homepage isn't loaded");
    }
}
