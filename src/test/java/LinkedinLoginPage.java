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

    public boolean isSignInButtonDisplayed()
    {
        return signInButton.isDisplayed();
    }
}
