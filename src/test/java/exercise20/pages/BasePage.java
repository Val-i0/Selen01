package exercise20.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class BasePage {
    /**
    * NOTE: NOT an exercise, it's my homework.
    * */
    protected WebDriver driver;
    private WebDriverWait wait;

    Actions action;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void validateErrorMessage(WebElement element, String errorMessage) {
        assertEquals(element.getText(), errorMessage);
    }

    public void waitElementToAppear(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void verifyUrl(String URL){
        wait.until(ExpectedConditions.urlToBe(URL));
    }

    public void scrollToElement(WebElement element) {
        action.scrollToElement(element);
        waitElementToAppear(element);
    }

}
