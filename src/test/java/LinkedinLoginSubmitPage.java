import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage extends LinkedinBasePage
{
    private WebElement emailField;
    private WebElement submitEmailField;
    private WebElement submitPasswordField;
    private WebElement submitSignInButton;
    private WebElement errorMessage;
    private WebElement errorEmailMessage;
    private WebElement errorPasswordMessage;

    public LinkedinLoginSubmitPage(WebDriver webDriver)
    {
        super(webDriver);
        initElements();
    }

    public void initElements()
    {
        emailField = webDriver.findElement(By.id("session_key-login"));
        submitEmailField = webDriver.findElement(By.id("session_key-login"));
        submitPasswordField = webDriver.findElement(By.id("session_password-login"));
        submitSignInButton = webDriver.findElement(By.id("btn-primary"));
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        errorEmailMessage = webDriver.findElement(By.id("session_key-login-error"));
        errorPasswordMessage = webDriver.findElement(By.id("session_password-login-error"));
    }

    public void login(String email, String password)
    {
        submitEmailField.sendKeys(email);
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
