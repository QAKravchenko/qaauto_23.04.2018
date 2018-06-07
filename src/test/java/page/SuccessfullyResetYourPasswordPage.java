package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Successfully reset your password page
 */
public class SuccessfullyResetYourPasswordPage extends BasePage
{
    /**
     * Constructor for "Successfully reset your password" page
     * @param webDriver - webdriver instance
     */
    public SuccessfullyResetYourPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(xpath = "//header[contains(text(), 'Your password has been changed successfully')]")
    private WebElement successMessage;

    @FindBy(id = "reset-password-submit-button")
    private WebElement goToHomepageButton;

    /**
     * Method for displaying of Success message of reset password
     * @return - returning of "Success message" element
     */
    public boolean isPageLoaded()
    {
       return successMessage.isDisplayed();
    }

    /**
     * Method of getting text of Success message
     * @return - returning got text of Success message
     */
    public String isSuccessMessageDisplayed()
    {
        return successMessage.getText();
    }

    /**
     * Method for clicking on "Go to Homepage" button
     * @return - returning of Pagefactory of Homepage
     */
    public HomePage clickOnGoToHomepageButton()
    {
        goToHomepageButton.click();
        return PageFactory.initElements(webDriver, HomePage.class);
    }
}
