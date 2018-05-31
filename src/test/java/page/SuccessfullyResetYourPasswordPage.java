package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessfullyResetYourPasswordPage extends LinkedinBasePage
{
    public SuccessfullyResetYourPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(xpath = "//header[contains(text(), 'Your password has been changed successfully')]")
    private WebElement successMessage;

    public boolean isPageLoaded()
    {
       return successMessage.isDisplayed();
    }

    public String isSuccessMessageDisplayed()
    {
        return successMessage.getText();
    }
}
