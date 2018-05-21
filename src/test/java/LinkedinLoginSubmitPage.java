import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage
{
    private WebDriver webDriver;

    private WebElement submitEmailField;
    private WebElement submitPasswordField;
    private WebElement submitSignInButton;
    private WebElement errorMessage;
    private WebElement errorEmailMessage;
    private WebElement errorPasswordMessage;

    public LinkedinLoginSubmitPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements()
    {
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

    public String getCurrentPageTitle()
    {
        return webDriver.getTitle();
    }

    public String getCurrentUrl()
    {
        return webDriver.getCurrentUrl();
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

    public String isErrorEmailMessageDisplayed()
    {
        return errorEmailMessage.getText();
    }

    public String isErrorPasswordMessageDisplayed()
    {
        return errorPasswordMessage.getText();
    }
}
