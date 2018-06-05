package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
        String messageSubject = "Tester, данное сообщение содержит ссылку для изменения пароля";
        String messageTo = "skravchenko@adyax.com";
        String messageFrom = "security-noreply@linkedin.com";
        String gMailMessage = gMailService.waitMessage(messageSubject, messageTo, messageFrom,60);
        String resetPasswordLink = StringUtils.substringBetween(gMailMessage,"нажмите <a href="+'"', '"'+" style=").replace("&amp;","&");
        webDriver.get(resetPasswordLink);
        return PageFactory.initElements(webDriver, ResetYourPasswordPage.class);
    }
}
