package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetYourPasswordPage extends BasePage
{
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

    public boolean isPageLoaded()
    {
        return newPasswordField.isDisplayed();
    }

    public SuccessfullyResetYourPasswordPage submitNewPassword(String newUserPassword)
    {
        newPasswordField.sendKeys(newUserPassword);
        confirmPasswordField.sendKeys(newUserPassword);
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, SuccessfullyResetYourPasswordPage.class);
    }
}
