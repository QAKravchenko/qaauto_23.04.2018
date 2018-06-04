package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class PleaseCheckYourEmailPage extends BasePage
{

    public PleaseCheckYourEmailPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(id = "resend-url")
    private WebElement resendLinkButton;

    public boolean isPageLoaded()
    {
        return resendLinkButton.isDisplayed();
    }

    public ResetYourPasswordPage navigateToLinkFromEmail()
    {
        GMailService gMailService = new GMailService();
        gMailService.connect();
        System.out.println(ResetPasswordPage.gMailMessage);
        String resetPasswordLink = StringUtils.substringBetween(ResetPasswordPage.gMailMessage,"нажмите <a href="+'"', '"'+" style=").replace("&amp;","&");
        System.out.println(resetPasswordLink);
        webDriver.get(resetPasswordLink);
        return PageFactory.initElements(webDriver, ResetYourPasswordPage.class);
    }
}
