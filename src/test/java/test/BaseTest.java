package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LoginPage;

import static java.lang.Thread.sleep;

public class BaseTest
{
    WebDriver webDriver;
    LoginPage loginPage;
    String userEmail = "skravchenko@adyax.com";
    String newUserPassword = "P@ssword2";

    @BeforeMethod
    public void before() throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.linkedin.com/");
        loginPage = new LoginPage(webDriver);
        sleep(2000);
    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}
