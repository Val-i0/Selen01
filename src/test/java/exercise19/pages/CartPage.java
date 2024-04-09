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

    @FindBys({
            @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    })
    private WebElement removeButton1;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}*/
