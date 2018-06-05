package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BasePage
{
    public ResetPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(id = "username")
    private WebElement emailOrPhoneField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    public boolean isPageLoaded()
    {
        return emailOrPhoneField.isDisplayed() && resetPasswordSubmitButton.isDisplayed();
    }

    public PleaseCheckYourEmailPage submitUserEmail(String email)
    {
        gMailService.connect();
        emailOrPhoneField.sendKeys(email);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, PleaseCheckYourEmailPage.class);
    }
}
