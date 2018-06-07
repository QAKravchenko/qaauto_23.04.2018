package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Error page after unsuccessful login
 */
public class LoginSubmitPage extends BasePage
{
    /**
     * Constructor of Error page
     * @param webDriver - webDriver instance
     */
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

    /**
     * Method for checking of displaying "General error message" text
     * @return - returning of loaded element
     */
    public boolean isPageLoaded()
    {
        return errorMessage.isDisplayed();
    }

    /**
     * Method for successful login on Error page
     */
    public void login()
    {
        submitEmailField.clear();
        submitEmailField.sendKeys("skravchenko@adyax.com");
        submitPasswordField.clear();
        submitPasswordField.sendKeys("P@ssword2");
        submitSignInButton.click();
    }

    /**
     * Method for checking of displaying "Sign in" button
     *  @return - returning of displayed element
     */
    public boolean isSignInButtonDisplayed()
    {
        return submitSignInButton.isDisplayed();
    }

    /**
     * Method to get text from General error message
     * @return - returning of got text
     */
    public String errorMessageText()
    {
        return errorMessage.getText();
    }

    /**
     * Method for checking of displaying "Email" field
     * @return - returning of displayed element
     */
    public boolean isSubmitEmailFieldDisplayed()
    {
        return submitEmailField.isDisplayed();
    }

    /**
     * Method for checking of displaying "Password" field
     * @return - returning of displayed element
     */
    public boolean isSubmitPasswordFieldDisplayed()
    {
        return submitPasswordField.isDisplayed();
    }

    /**
     * Method for checking of displaying "Error message" for "Email" field
     * @return - returning of displayed element
     */
    public boolean isErrorEmailMessageDisplayed()
    {
        return errorEmailMessage.isDisplayed();
    }

    /**
     * Method for getting of text of "Error message" for "Email" field
     * @return - returning of got text
     */
    public String isErrorEmailMessageTextDisplayed()
    {
        return errorEmailMessage.getText();
    }

    /**
     * Method for checking of displaying "Error message" for "Password" field
     * @return - returning of displayed element
     */
    public boolean isErrorPasswordMessageDisplayed()
    {
        return errorPasswordMessage.isDisplayed();
    }

    /**
     * Method for getting of text of "Error message" for "Password" field
     * @return - returning of got text
     */
    public String isErrorPasswordMessageTextDisplayed()
    {
        return errorPasswordMessage.getText();
    }
}
