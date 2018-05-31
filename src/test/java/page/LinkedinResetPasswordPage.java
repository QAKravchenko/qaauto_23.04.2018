package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinResetPasswordPage extends LinkedinBasePage
{
    public LinkedinResetPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(className = "content__header")
    private WebElement headerText;

    @FindBy(className = "form__subtitle")
    private WebElement subTitle;

    @FindBy(xpath = "//label[@class='form__label required']")
    private WebElement label;

    @FindBy(id = "username")
    private WebElement emailOrPhoneField;

    @FindBy(id = "reset-password-submit-button")
    private WebElement resetPasswordSubmitButton;

    public boolean isPageLoaded()
    {
        return emailOrPhoneField.isDisplayed();
    }

    public boolean isHeaderTextDisplayed()
    {
        return headerText.isDisplayed();
    }

    public boolean isSubTitleDisplayed()
    {
        return subTitle.isDisplayed();
    }

    public boolean isLabelDisplayed()
    {
        return label.isDisplayed();
    }

    public boolean isEmailOrPhoneFieldDisplayed()
    {
        return emailOrPhoneField.isDisplayed();
    }


    public boolean isResetPasswordSubmitButtonDisplayed()
    {
        return resetPasswordSubmitButton.isDisplayed();
    }

    public LinkedinRequestPasswordPage requestPasswordPage()
    {
        emailOrPhoneField.sendKeys("skravchenko@adyax.com");
        resetPasswordSubmitButton.click();
        return PageFactory.initElements(webDriver, LinkedinRequestPasswordPage.class);
    }

}
