import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static java.lang.Thread.sleep;

public class NegativeLoginTest
{
    WebDriver webDriver;

    @BeforeMethod
    public void before()
    {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.get("https://www.linkedin.com/");
    }

    @Test
    public void successfulLoginTest() throws InterruptedException
    {
//        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage();
//        linkedinLoginPage.login("skravchenko@adyax.com", "adyax111");

// Checking the title of the page is "LinkedIn: Log In or Sign Up"
        Assert.assertEquals(webDriver.getTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong!");

// Checking URL is "https://www.linkedin.com/"
        Assert.assertEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/",
                "Homepage URL is wrong!");

// Checking "Login" field is displayed on "Login" page
//        Assert.assertTrue(loginField.isDisplayed(), "Login field isn't displayed!");

/*
// NEGATIVE TEST CASES FOR LOGIN
        // 1 case
        signInButton.click();
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");

        // 2 case
        loginField.sendKeys("skravchenko@adyax.com");
        signInButton.click();
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");

        // 3 case
        loginField.clear();
        passwordField.sendKeys("adyax111");
        signInButton.click();
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");

        // 4 case
        loginField.clear();
        passwordField.clear();
        loginField.sendKeys("skravchenko@adyax.com");
        passwordField.sendKeys("adyax11");
        signInButton.click();
        sleep(2000);
        String errorMessage = webDriver.findElement(By.xpath("//strong")).getText();
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");
        Assert.assertTrue(errorMessage.contentEquals("There were one or more errors in your submission. Please correct the marked fields below."));

        // 5 case
        WebElement loginField2 = webDriver.findElement(By.id("session_key-login"));
        WebElement passwordField2 = webDriver.findElement(By.id("session_password-login"));
        WebElement signInButton2 = webDriver.findElement(By.id("btn-primary"));
        loginField2.clear();
        passwordField2.clear();
        loginField2.sendKeys("skravchenkoadyax.com");
        passwordField2.sendKeys("adyax111");
        signInButton2.click();
        sleep(2000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");

        // 6 case
        loginField2.clear();
        passwordField2.clear();
        loginField2.sendKeys("skravchenkoadyax.com");
        passwordField2.sendKeys("adyax1");
        signInButton2.click();
        sleep(2000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");

        // 7 case
        loginField2.clear();
        passwordField2.clear();
        loginField2.sendKeys("adyax111");
        passwordField2.sendKeys("skravchenko@adyax.com");
        signInButton2.click();
        sleep(2000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Login successful !!!");
*/


    }

    @Test
    public void negativeLoginTest() throws InterruptedException {

        String actualLoginPageTitle = webDriver.getTitle();

        Assert.assertEquals(actualLoginPageTitle,
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong!");

        WebElement loginField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        WebElement signInButton = webDriver.findElement(By.id("login-submit"));

        loginField.sendKeys("skravchenko@adyax.com");
        passwordField.sendKeys("adyax11");
        signInButton.click();
        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();

        Assert.assertEquals(currentPageUrl,
                "https://www.linkedin.com/uas/login-submit",
                "Login-Submit page URL is wrong");
        Assert.assertEquals(currentPageTitle,
                "Sign In to LinkedIn",
                "Login-Submit page Title is wrong");
        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message text displayed");
}

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}