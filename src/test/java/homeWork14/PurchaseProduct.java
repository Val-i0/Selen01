package homeWork14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PurchaseProduct extends MainDriver {
    @Test
    public void buyProduct() throws InterruptedException {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        Thread.sleep(1000); // for visibility

        //WebElement backpack = driver.findElement(By.xpath("//a//div[text()='Sauce Labs Backpack']"));
        WebElement buttonBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        buttonBackpack.click();

        Thread.sleep(1000);

        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();

        Thread.sleep(1000);

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        Thread.sleep(1000);

        // using diff type selectors just for the exercise. id is present everywhere, it is boring.
        WebElement fNameField = driver.findElement(By.cssSelector("[placeholder='First Name']"));
        fNameField.sendKeys("John");

        WebElement lNameField = driver.findElement(By.xpath("//input[@data-test='lastName']"));
        lNameField.sendKeys("Doe");

        WebElement zipCodeField = driver.findElement(By.name("postalCode"));
        zipCodeField.sendKeys("9000");

        Thread.sleep(1000);

        WebElement continueButton =driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        Thread.sleep(1000);

        WebElement finishButton = driver.findElement(By.cssSelector("button#finish"));
        finishButton.click();

        Thread.sleep(1000);

    }
}
