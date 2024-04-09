package exercise21.pages;

import exercise21.pages.BasePage;
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
        if(listOfRemoveButtons.size() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public void removeItem(){
        listOfRemoveButtons.get(0).click();
    }
}
