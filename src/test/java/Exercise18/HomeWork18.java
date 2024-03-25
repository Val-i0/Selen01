package Exercise18;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomeWork18 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(412, 915)); // resize to Pixel 7 - 412 x 915
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void jsScrollTest() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        // login
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.cssSelector("input[type='password']")); // not by id, for fun
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']")); // by xpath, again for fun
        loginButton.click();

        wait.until(ExpectedConditions.urlToBe("https://www.saucedemo.com/inventory.html"));

        WebElement footerText = driver.findElement(By.className("footer_copy"));

        // v1
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", footerText);

        // v2
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView();", footerText);

        // v3 - no JS, doesn't perform so well
//        Actions action = new Actions(driver);
//        action.moveToElement(footerText).perform();

        assertTrue(footerText.isDisplayed());
        Thread.sleep(3000); // just for visibility of the end result!
    }

    @Test
    public void clickViaJsTest() throws InterruptedException {
        driver.manage().window().maximize(); // saving time by overriding window().setSize() from setup() method
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement buttonLogin = driver.findElement(By.cssSelector("button[type='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", buttonLogin);

        Thread.sleep(1500); // again, so you can see the result

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div#flash.flash.error")));
        String err = driver.findElement(By.cssSelector("div#flash.flash.error")).getText().trim();
        assertEquals("Your username is invalid!", err.substring(0, 25));

        String color = driver.findElement(By.cssSelector("div#flash.flash.error")).getCssValue("background-color"); // rgba(198, 15, 19, 1)
        assertEquals(color, "rgba(198, 15, 19, 1)");
    }
}
