package exercise20;

import exercise20.pages.AutomationQAPage;
import exercise20.pages.HomePage;
import org.testng.annotations.Test;

public class AutomationPageTest extends MainDriver {

    HomePage homePage;
    AutomationQAPage automationQAPage;

    @Test
    public void filterAutoQAPage() {
        homePage = new HomePage(driver);
        homePage.verifyHomePageUrl();
        homePage.closeDevBGPopup();
        homePage.scrollToAutoQALink();
        homePage.clickAutoQALink();

        automationQAPage = new AutomationQAPage(driver);
        automationQAPage.verifyAutoQAPage();

        automationQAPage.leftFilterPanel().clickFullyRemote();
        automationQAPage.waitVisibilityOfLabelFullyRemote();

        automationQAPage.leftFilterPanel().clickVarna();
        automationQAPage.waitVisibilityOfLabelVarna();

        automationQAPage.verifyFilteredAutoQAPageURL();

        System.out.println("Done, goddamnit");
    }
}
