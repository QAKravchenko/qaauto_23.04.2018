package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;


public class LoginPage extends BasePage
{
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

    @Override
    public boolean isPageLoaded()
    {
        return signInButton.isDisplayed();
    }

    public HomePage login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }

    public LoginSubmitPage loginSubmitPage(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LoginSubmitPage.class);
    }

    public ResetPasswordPage clickOnForgotPasswordLink()
    {
        forgotPasswordLink.click();
        return PageFactory.initElements(webDriver, ResetPasswordPage.class);
    }

    public void successfulLoginWithNewPassword(String userEmail, String newUserPassword) throws InterruptedException
    {
        emailField.sendKeys(userEmail);
        passwordField.sendKeys(newUserPassword);
        signInButton.click();
        sleep(3000);
    }


    //Example, how to return one of three pages
 /*
    public <T> T login(String email, String password)
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
*/
}
