package exercise19.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCart extends BasePage {
    @FindBy(css = ".cart_button")
    private List<WebElement> listOfRemoveButtons;

    public ShoppingCart(WebDriver driver) {
        super(driver);
    }

    public boolean isItemAdded() {
        if (listOfRemoveButtons.size() > 0) {
            return true;
        } else {
            return false;
        }
        // alternative way:
        // return listOfRemoveButtons.size() != 0;
    }

    public void removeItem(){
        listOfRemoveButtons.get(0).click();
    }
}
