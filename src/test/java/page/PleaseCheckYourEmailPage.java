package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page for checking sent email with link to reset password
 */
public class PleaseCheckYourEmailPage extends BasePage
{

    /**
     * Constructor of Check your email page
     * @param webDriver - webDriver instance
     */
    public PleaseCheckYourEmailPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(id = "resend-url")
    private WebElement resendLinkButton;

    /**
     * Method for checking of displaying "Resend link" button
     * @return - returning of "Resend link" button
     */
    public boolean isPageLoaded()
    {
        return resendLinkButton.isDisplayed();
    }

    /**
     * Method for navigation to "Reset your password" page from link in received email using GMail service
     * @return
     */
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
