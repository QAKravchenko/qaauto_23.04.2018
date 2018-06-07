package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.LoginPage;

import static java.lang.Thread.sleep;

public class BaseTestUa
{
    public WebDriver webDriver;
    public LoginPage loginPage;
    public String userEmail = "skravchenko@adyax.com";
    public String newUserPassword = "P@ssword2";

    @Parameters({"browserType", "envURL"})
    @BeforeMethod
    public void before(@Optional("chrome") String browserType, @Optional("https://ua.linkedin.com/") String envURL) throws InterruptedException
    {
        switch (browserType.toLowerCase())
        {
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
                break;
            case "chrome" :
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                webDriver.manage().window().maximize();
                break;
            default :
                WebDriverManager.iedriver().setup();
                webDriver = new InternetExplorerDriver();
                webDriver.manage().window().maximize();
        }

        webDriver.navigate().to(envURL);
        loginPage = new LoginPage(webDriver);
        sleep(2000);
    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}
