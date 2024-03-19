package exercise16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Homework16 {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void killDriver() {
        driver.quit();
    }

    @Test
    public void clickEdit() {
        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement editButton = driver.findElement(By.xpath("//table[@id='table1']//tr[3]//a[@href='#edit']"));
        Assert.assertTrue(editButton.isDisplayed());
        editButton.click();

        assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/tables#edit");
    }

    @Test
    public void clickEdit2() {
        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement table1 = driver.findElement(By.cssSelector("table#table1 tbody"));

        List<WebElement> rows = table1.findElements(By.tagName("tr"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (WebElement cell : cells) {
                String text = cell.getText();
                if (text.equals("Doe")) {
                    WebElement editButton = row.findElement(By.cssSelector("a[href='#edit']"));
                    editButton.click();
                    break;
                }
            }
        }

        assertEquals("https://the-internet.herokuapp.com/tables#edit", driver.getCurrentUrl());
    }
}
