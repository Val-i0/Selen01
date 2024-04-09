package exercise19;

import exercise19.pages.CartPage;
import exercise19.pages.LoginPage;
import exercise19.pages.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsPageTest extends MainDriver {
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
