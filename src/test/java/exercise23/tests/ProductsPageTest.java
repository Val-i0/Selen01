package exercise23.tests;

import exercise23.base.MainTest;
import exercise23.pages.CartPage;
import exercise23.pages.LoginPage;
import exercise23.pages.ProductsPage;
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
