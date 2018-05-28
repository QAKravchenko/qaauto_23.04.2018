import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends LinkedinBasePage
{
    public LinkedinLoginSubmitPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
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

    public void login(String email, String password)
    {
        submitEmailField.clear();
        submitEmailField.sendKeys(email);
        submitPasswordField.clear();
        submitPasswordField.sendKeys(password);
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

    public boolean isPageLoaded()
    {
        return emailField.isDisplayed();
    }
}
