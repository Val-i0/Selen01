package exercise15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPage extends MainDriver {
    @Test
    public void loginPageEmptyFieldsClick() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");

        WebElement loginButton = driver.findElement(By.cssSelector("input[type=\"submit\"]"));
        loginButton.click();

        Thread.sleep(1000);

        WebElement errorMessage = driver.findElement(By.className("error-message-container"));
        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertEquals(errorMessage.getText(), "Epic sadface: Username is required");
        String color = errorMessage.getCssValue("background-color"); // rgba(226, 35, 26, 1)
        Assert.assertEquals(color, "rgba(226, 35, 26, 1)");

        Thread.sleep(1000);
    }
}
