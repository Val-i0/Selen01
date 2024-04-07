package exercise20.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final String URL = "https://dev.bg/";

    @FindBy(css = "a > div.icon-automation-qa")
    private WebElement autoQALink;

    @FindBy(css = "button.cmplz-accept")
    private WebElement cookiePopupButton;
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent header() {
        return new HeaderComponent(driver);
    }

    public void verifyHomePageUrl() {
        verifyUrl(URL);
    }

    public void scrollToAutoQALink() {
        scrollToElement(autoQALink);
    }

    public void clickAutoQALink() {
        clickElement(autoQALink);
    }

    public void closeDevBGPopup() {
        clickElement(cookiePopupButton);
    }
}
