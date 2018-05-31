package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LinkedinLoginPage;

import static java.lang.Thread.sleep;

public class LinkedinBaseTest
{
    WebDriver webDriver;
    LinkedinLoginPage linkedinLoginPage;

    @BeforeMethod
    public void before() throws InterruptedException
    {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.linkedin.com/");
        linkedinLoginPage = new LinkedinLoginPage(webDriver);
        sleep(2000);
    }

    @AfterMethod
    public void after()
    {
        webDriver.close();
    }
}
