package exercise21;

import exercise21.base.MainTest;
import exercise21.pages.LoginPage;
import exercise21.pages.ProductsPage;
import exercise21.pages.ShoppingCart;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends MainTest {
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
