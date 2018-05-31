package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseNewPasswordPage extends LinkedinBasePage
{
    public ChooseNewPasswordPage(WebDriver webDriver)
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
}
