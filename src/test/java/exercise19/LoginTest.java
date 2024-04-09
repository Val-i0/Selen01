package exercise19;

import exercise19.pages.LoginPage;
import exercise19.pages.ProductsPage;
import exercise19.pages.ShoppingCart;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.testng.AssertJUnit.*;

public class LoginTest extends MainDriver {
    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void testSuccessfulLogin() {
        loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.setPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage = new ProductsPage(driver);

        productsPage.addProduct();
        productsPage.openShoppingCart();

        ShoppingCart cart = new ShoppingCart(driver);
        assertTrue(cart.isItemAdded());

        cart.removeItem();
        assertFalse(cart.isItemAdded());


    }

    @Test
    public void testNotValidLogin() {
        SoftAssert soft = new SoftAssert();
        loginPage = new LoginPage(driver);
        loginPage.setUsername("");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLoginButton();

        soft.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");

        loginPage.setUsername("standard_user");
        loginPage.setPassword("");
        loginPage.clickLoginButton();

        soft.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
        soft.assertAll();




    }

//    @Test
//    public void removeBasketProduct() throws InterruptedException {
//        loginPage = new LoginPage(driver);
//        loginPage.setUserName("standard_user");
//        loginPage.setPassword("secret_sauce");
//        loginPage.clickLoginButton();
//
//        productsPage = new ProductsPage(driver);
//        assertEquals(productsPage.getPageTitle(), "Products");
//
//        productsPage.addToCart();
//        assertEquals(productsPage.getButtonTitle(), "Remove");
//
//        productsPage.cartClick();
//        assertEquals(productsPage.getPageTitle(), "Your Cart");
//
//        Thread.sleep(3000);
//    }

}
