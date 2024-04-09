package exercise21.pages;

import org.openqa.selenium.WebDriver;

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
