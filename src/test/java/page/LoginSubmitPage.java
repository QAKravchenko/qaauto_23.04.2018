package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSubmitPage extends BasePage
{
    public LoginSubmitPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(id = "session_key-login")
    private WebElement emailField;

    @FindBy(id = "session_key-login")
    private WebElement submitEmailField;

    @FindBy(id = "session_password-login")
    private WebElement submitPasswordField;

    @FindBy(id = "btn-primary")
    private WebElement submitSignInButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement errorMessage;

    @FindBy(id = "session_key-login-error")
    private WebElement errorEmailMessage;

    @FindBy(id = "session_password-login-error")
    private WebElement errorPasswordMessage;

    public boolean isPageLoaded()
    {
        return errorMessage.isDisplayed();
    }

    public void login()
    {
        submitEmailField.clear();
        submitEmailField.sendKeys("skravchenko@adyax.com");
        submitPasswordField.clear();
        submitPasswordField.sendKeys("P@ssword2");
        submitSignInButton.click();
    }

    public boolean isSignInButtonDisplayed()
    {
        return submitSignInButton.isDisplayed();
    }

    public String errorMessageText()
    {
        return errorMessage.getText();
    }

    public boolean isSubmitEmailFieldDisplayed()
    {
        return submitEmailField.isDisplayed();
    }

    public boolean isSubmitPasswordFieldDisplayed()
    {
        return submitPasswordField.isDisplayed();
    }

    public boolean isErrorEmailMessageDisplayed()
    {
        return errorEmailMessage.isDisplayed();
    }

    public String isErrorEmailMessageTextDisplayed()
    {
        return errorEmailMessage.getText();
    }

    public boolean isErrorPasswordMessageDisplayed()
    {
        return errorPasswordMessage.isDisplayed();
    }

    public String isErrorPasswordMessageTextDisplayed()
    {
        return errorPasswordMessage.getText();
    }
}
