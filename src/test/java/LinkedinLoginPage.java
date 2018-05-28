import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginPage extends LinkedinBasePage
{
    public LinkedinLoginPage(WebDriver webDriver)
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

    @Override
    public boolean isPageLoaded()
    {
        return signInButton.isDisplayed();
    }

    public LinkedinHomePage login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    }

    public LinkedinLoginSubmitPage loginSubmitPage(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
        return PageFactory.initElements(webDriver, LinkedinLoginSubmitPage.class);
    }

/*    public <T> T login(String email, String password)
    {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();

        if (getCurrentUrl().contains("/feed"))
        {return  (T) new LinkedinHomePage(webDriver);}

        if (getCurrentUrl().contains("/login-submit"))
        {return  (T) new LinkedinLoginSubmitPage(webDriver);}

        else {return (T) this;}
    }
*/
}
