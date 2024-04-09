package exercise21.pages;

import exercise21.pages.BasePage;
import exercise21.pages.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement item;

    @FindBy(css = ".shopping_cart_badge")
    private WebElement shoppingCartBadge;


    public ProductsPage (WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void addProduct() {
        item.click();
    }

    public void openShoppingCart() {
        waitForElementToBeVisible(shoppingCartBadge);
        shoppingCartBadge.click();
    }

    // IMPORTANT!!! Return the Header in the ProductPage, so I can use it in ProductTest
    public HeaderComponent header () {
        return new HeaderComponent(driver);
    }
/*

    @FindBy(xpath = "//div[@class='inventory_list']/div[1]//button")
    private WebElement firstItemButton;

    @FindBy(css = "a.shopping_cart_link")
    private WebElement cartLink;

    // etc. elements

    public ProductsPage (WebDriver driver) {
        super(driver);
    }



    public void addToCart() {
        firstItemButton.click();
    }

    public String getButtonTitle() {
        return firstItemButton.getText();
    }

    public void cartClick() {
        cartLink.click();
    }*/
}