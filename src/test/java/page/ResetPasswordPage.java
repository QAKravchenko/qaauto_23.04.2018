package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Reset password page
 */
public class ResetPasswordPage extends BasePage
{
    /**
     * Constructor of "Reset password" page
     * @param webDriver - webDriver instance
     */
    public ResetPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(id = "username")
    private WebElement emailOrPhoneField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    /**
     * Method for checking of displaying "Email or Phone" field
     * @return - returning of "Email or Phone" field
     */
    public boolean isPageLoaded()
    {
        return emailOrPhoneField.isDisplayed() && resetPasswordSubmitButton.isDisplayed();
    }

    /**
     * Method for receiving email with link to reset new password
     * @param email - variable for email address
     * @return - returning of Pagefactory of "Please check your email" page
     */
    public PleaseCheckYourEmailPage submitUserEmail(String email)
    {
        gMailService.connect();
        emailOrPhoneField.sendKeys(email);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, PleaseCheckYourEmailPage.class);
    }
}
