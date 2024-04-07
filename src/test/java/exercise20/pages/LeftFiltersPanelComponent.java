package exercise20.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftFiltersPanelComponent extends BasePage {
    @FindBy(css = "div[data-value='remote']")
    private WebElement checkmarkFullyRemote;

    @FindBy(css = "div[data-value='varna']")
    private WebElement checkmarkVarna;

    public LeftFiltersPanelComponent(WebDriver driver) {
        super(driver);
    }

    public void clickFullyRemote() {
        clickElement(checkmarkFullyRemote);
    }

    public void clickVarna() {
        clickElement(checkmarkVarna);
    }
}
