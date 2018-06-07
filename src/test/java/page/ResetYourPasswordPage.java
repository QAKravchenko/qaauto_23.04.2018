package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Reset your password page
 */
public class ResetYourPasswordPage extends BasePage
{
    /**
     * Constructor for "Reset your password" page
     * @param webDriver - webDriver instance
     */
    public ResetYourPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    /**
     * Method for checking of displaying "New password" field
     * @return - returning of "New password" field
     */
    public boolean isPageLoaded()
    {
        return newPasswordField.isDisplayed();
    }

    /**
     * Method for submition new password
     * @param newUserPassword - variable for new password
     * @return - returning of Pagefactory of "Successful reset your password" page
     */
    public SuccessfullyResetYourPasswordPage submitNewPassword(String newUserPassword)
    {
        newPasswordField.sendKeys(newUserPassword);
        confirmPasswordField.sendKeys(newUserPassword);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, SuccessfullyResetYourPasswordPage.class);
    }
}
