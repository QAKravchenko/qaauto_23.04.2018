package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfullyResetYourPasswordPage extends BasePage
{
    public SuccessfullyResetYourPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(xpath = "//header[contains(text(), 'Your password has been changed successfully')]")
    private WebElement successMessage;

    @FindBy(id = "reset-password-submit-button")
    private WebElement goToHomepageButton;

    public boolean isPageLoaded()
    {
       return successMessage.isDisplayed();
    }

    public String isSuccessMessageDisplayed()
    {
        return successMessage.getText();
    }

    public HomePage clickOnGoToHomepageButton()
    {
        goToHomepageButton.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }
}
