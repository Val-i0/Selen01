package exercise20.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends BasePage {
    @FindBy(css = "[class='button bold subscriber-register-btn']")
    private WebElement createProfileButton;

    @FindBy(css = "input[name='Submitted']")
    private WebElement formCreateProfileButton;

    @FindBy(css = "div.subscriber-register-wrapper.open > div.inner")
    private WebElement formOpen;

    @FindBy(id = "consent-error")
    private WebElement formErrorMessage;
    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void clickCreateProfileButton() {
        clickElement(createProfileButton);
    }

    public void formCreateProfileButton() {
        clickElement(formCreateProfileButton);
    }


    public void validateFormErrorMessage() {
        waitElementToAppear(formOpen);
        validateErrorMessage(formErrorMessage, "Трябва да се съгласите с условията, преди да се регистрирате");
    }
}
