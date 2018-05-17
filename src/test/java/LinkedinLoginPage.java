import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LinkedinLoginPage
{
    private WebDriver webDriver;

/*    public LinkedinLoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        loginField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }

    */

    private WebElement loginField;
    private WebElement passwordField;
    private  WebElement signInButton;

    public LinkedinLoginPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements()
    {
        loginField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signInButton = webDriver.findElement(By.id("login-submit"));
    }

/*    public boolean isSignInButtonDisplayed()
    {
        Assert.assertTrue(signInButton.isDisplayed(), "signInButton isn't displayed");
        return true;
    }
*/
    public void login(String email, String password)
    {
        loginField.sendKeys(email);
        passwordField.sendKeys(password);
        signInButton.click();
    }

}
