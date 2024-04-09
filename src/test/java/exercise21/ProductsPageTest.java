package exercise21;

import exercise21.base.MainTest;
import exercise21.pages.ProductsPage;
import exercise21.pages.CartPage;
import exercise21.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends MainTest {
    private ProductsPage productsPage;

    @BeforeMethod
    public void loginBefore() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");
    }

    @Test
    public void canOpenCart() {
        productsPage = new ProductsPage(driver);
        productsPage.header().openCartByIcon();

        CartPage cartPage = new CartPage(driver);
        cartPage.header().openCartByIcon(); // example again, accessing header from cart page
    }
}
