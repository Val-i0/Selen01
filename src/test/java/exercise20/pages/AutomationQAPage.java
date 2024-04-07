package exercise20.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutomationQAPage extends BasePage {
    private String autoQAPage = "https://dev.bg/company/jobs/automation-qa/";
    private String remoteVarnaJob = "https://dev.bg/company/jobs/automation-qa/?_job_location=remote%2Cvarna";
    @FindBy(css = "li [data-value='remote']")
    private WebElement labelFullyRemote;

    @FindBy(css = "li [data-value='varna']")
    private WebElement labelVarna;

    @FindBy(xpath = "//div[@class='container container-with-sidebar left-sidebar']")
    private WebElement loadingScreen;

    public AutomationQAPage(WebDriver driver) {
        super(driver);
    }

    public void verifyAutoQAPage() {
        verifyUrl(autoQAPage);
    }
    public void verifyFilteredAutoQAPageURL() {
        verifyUrl(remoteVarnaJob);
    }

    public LeftFiltersPanelComponent leftFilterPanel() {
        return new LeftFiltersPanelComponent(driver);
    }

    public void waitVisibilityOfLabelFullyRemote() {
        waitElementToAppear(labelFullyRemote);
    }

    public void waitVisibilityOfLabelVarna() {
        waitElementToAppear(labelVarna);
    }
}
