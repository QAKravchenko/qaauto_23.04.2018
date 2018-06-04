package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class ResetPasswordPage extends BasePage
{
    public ResetPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    public static String gMailMessage;

    @FindBy(id = "username")
    private WebElement emailOrPhoneField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    public boolean isPageLoaded()
    {
        return emailOrPhoneField.isDisplayed();
    }

    public PleaseCheckYourEmailPage submitUserEmail(String email)
    {
        GMailService gMailService = new GMailService();
        gMailService.connect();
        emailOrPhoneField.sendKeys(email);
        resetPasswordSubmitButton.click();
        gMailMessage = gMailService.waitMessage("Tester, данное сообщение содержит ссылку для изменения пароля", "skravchenko@adyax.com", "security-noreply@linkedin.com", 60);
        return PageFactory.initElements(webDriver, PleaseCheckYourEmailPage.class);
    }
}
