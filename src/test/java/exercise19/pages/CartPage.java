package exercise19.pages;

import exercise19.MainDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent header () {
        return new HeaderComponent(driver);
    }
}


/*public class CartPage  {
    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "titleZ")
    private List<WebElement> passwordInput;

    // try to find your element in several different ways, by diff locators:
    @FindBys({
            @FindBy(xpath = "//button[contains(text(), 'Remove')]"),
            @FindBy(xpath = "//button[@example="manyFindBys"])
    })
    private WebElement removeButton1;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    // example check if list of elements is empty. Then with assertTrue check if true.
    public boolean isCartEmpty() {
        if (passwordInput.size() == 0) {
            return true;
        } else {
            return false;
        }

    }
}*/
