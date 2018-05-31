package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.LinkedinBasePage;

public class LinkedinRequestPasswordPage extends LinkedinBasePage
{
    public LinkedinRequestPasswordPage(WebDriver webDriver)
    {
        super(webDriver);
    }

    @FindBy(className = "content__header")
    private WebElement headerContent;

    @FindBy(className = "form__subtitle")
    private WebElement subTitle;

    @FindBy(xpath = "//a[@class='different__email different__email--desktop']")
    private WebElement tryDifferentEmailButon;

    @FindBy(id = "resend-url")
    private WebElement resendLinkButton;

    public boolean isPageLoaded()
    {
        return headerContent.isDisplayed();
    }

    public boolean isTryDifferentEmailButonDisplayed()
    {
        return tryDifferentEmailButon.isDisplayed();
    }

    public boolean isResendLinkButton()
    {
        return resendLinkButton.isDisplayed();
    }

}
