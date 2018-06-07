package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


/**
 * Login page of Linkedin
 */
public class LoginPage extends BasePage
{
    /**
     * Constructor of Login page
     * @param webDriver - webDriver instance
     */
    public LoginPage(WebDriver webDriver)
    {
        super(webDriver);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id = "login-email")
    private WebElement emailField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-submit")
    private WebElement signInButton;

    @FindBy(className = "link-forgot-password")
    private WebElement forgotPasswordLink;

    /**
     * Method for checking of loading "Sign in" element
     * @return - returning of loaded element
     */
    @Override
    public boolean isPageLoaded()
    {
        return signInButton.isDisplayed();
    }

    /**
     * Method for successful login
     * @param email - variable for email address
     * @param password - variable for password
     * @return - returning Pagefactory of Homepage
     */
    public HomePage login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    /**
     * Method for unsuccessful login
     * @param email - variable for email address
     * @param password - variable for password
     * @return - returning Pagefactory of Login page with error
     */
    public LoginSubmitPage loginSubmitPage(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LoginSubmitPage.class);
    }

    /**
     * Method to click on "Forgot password" link on Homepage
     * @return - returning Pagefactory of Reset password page
     */
    public ResetPasswordPage clickOnForgotPasswordLink()
    {
        forgotPasswordLink.click();
        return PageFactory.initElements(webDriver, ResetPasswordPage.class);
    }

    /**
     * Method for successful login with new reset password
     * @param userEmail - variable of user email address
     * @param newUserPassword - variable of new reset password
     * @throws InterruptedException - Exception for sleep using
     */
    public void successfulLoginWithNewPassword(String userEmail, String newUserPassword) throws InterruptedException
    {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(newUserPassword);
        signInButton.click();
        sleep(3000);
    }


    /**
     * Method for login which returns opened page
     * @param email - variable of user email address
     * @param password - variable of password
     * @param <T> ???????????????????????????????????
     * @return - returning of opened page
     */
    public <T> T login2(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();

        if (getCurrentUrl().contains("/feed"))
        {return  (T) new page.HomePage(webDriver);}

        if (getCurrentUrl().contains("/login-submit"))
        {return  (T) new page.LoginSubmitPage(webDriver);}

        else {return (T) this;}
    }
}
