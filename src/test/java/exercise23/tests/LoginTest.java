package exercise23.tests;

import com.opencsv.exceptions.CsvException;
import exercise23.base.MainTest;
import exercise23.pages.LoginPage;
import exercise23.pages.ProductsPage;
import exercise23.pages.ShoppingCart;
import exercise23.utils.CsvReader;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.*;

public class LoginTest extends MainTest {
    LoginPage loginPage;
    ProductsPage productsPage;

    @DataProvider(name = "login-data")
    public static Object[][] dataProviderHardcodedData() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"visual_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "login-data-file")
    public static Object[][] dataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/login-data.csv");
    }

    @Test(dataProvider = "login-data-file")
    public void testSuccessfulLogin(String username, String password) {
        loginPage = new LoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);

        loginPage.clickLoginButton();

    }

    @DataProvider(name = "invalid-login-data")
    public static Object[][] invalidDataProviderFromCsvFile() throws IOException, CsvException {
        return CsvReader.readCsvFile("src/test/resources/invalid-login-data.csv");
    }

    @Test(dataProvider = "invalid-login-data")
    public void testNotValidLogin(String username, String password, String result) {
        loginPage = new LoginPage();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();

        assertEquals(loginPage.getErrorMessage(), result);

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
