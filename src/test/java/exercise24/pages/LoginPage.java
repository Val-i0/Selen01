package exercise24.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = ".error-message-container")
    private WebElement errorMessageContainer;

    // examples of structure of Test Case tickets - adding Test Steps, applied to the tests here
    @Step("Set Username")
    public void setUsername(String username) {
        usernameInput.sendKeys(username);
    }

    @Step("Set Password")
    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }


    public String getErrorMessage() {
        return errorMessageContainer.getText();
    }

    public void loginAs(String userName, String password) {
        setUsername(userName);
        setPassword(password);
        clickLoginButton();
    }
}
// clever "hack" by AD
//    public ProductsPage clickLoginButton() {
//        loginButton.click();
//        return new ProductsPage(driver);
//    }