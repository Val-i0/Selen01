package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.time.Duration;

public class SeleniumDemoCopyTest extends MainDriver {
    @Test
    public void test0PenBrowser() {

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();
    }


}
