package exercise24.tests;

import exercise24.MainTest;
import exercise24.pages.CartPage;
import exercise24.pages.LoginPage;
import exercise24.pages.ProductsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends MainTest {
    private ProductsPage productsPage;

    @BeforeMethod
    public void loginBefore() {
        LoginPage loginPage = new LoginPage();
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void canOpenCart() {
        productsPage = new ProductsPage();
        productsPage.header().openCartByIcon();

        CartPage cartPage = new CartPage();
        cartPage.header().openCartByIcon(); // example again, accessing header from cart page
    }
}
