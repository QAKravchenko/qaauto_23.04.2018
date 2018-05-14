import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest
{
    @Test
    public void successfulLoginTest() throws InterruptedException
    {
        
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://www.linkedin.com/");

        String actualPageTitle = webDriver.getTitle();
        WebElement loginField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

// Checking the title of the page is "LinkedIn: Log In or Sign Up"
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong!");

// Checking URL is "https://www.linkedin.com/"
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Homepage URL is wrong!");

// Checking "Login" field is displayed on "Login" page
        Assert.assertTrue(loginField.isDisplayed(), "Login field isn't displayed!");


// START CHECKING SUCCESSFUL LOGIN
// Typing login into "Login" field
        loginField.sendKeys("skravchenko@adyax.com");

// Typing password into "Password" field
        passwordField.sendKeys("adyax111");

// Clicking on "Submit" button
        signInButton.click();

        sleep(3000);
// END CHECKING SUCCESSFUL LOGIN


// Checking the title of the page is "LinkedIn"
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn",
                "Homepage Title is wrong!");

        String actualHomePageTitle = webDriver.getTitle();

        Assert.assertNotEquals(actualPageTitle, actualHomePageTitle,
                "Login page Title is wrong!");

// Checking URL is "https://www.linkedin.com/feed/"
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "URL is wrong!");

// Checking "Home" button is displayed on Homepage
        WebElement homeButton = webDriver.findElement(By.id("feed-nav-item"));
        Assert.assertTrue(homeButton.isDisplayed(), "Home button isn't displayed!");

        webDriver.close();

    }
}