package exercise20;

import exercise20.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends MainDriver {
    HomePage homePage;

    @Test
    public void negativeCreateProfileTest() {
        homePage = new HomePage(driver);
        homePage.verifyHomePageUrl();
        homePage.header().clickCreateProfileButton();
        homePage.header().formCreateProfileButton();
        homePage.header().validateFormErrorMessage();
    }
}
