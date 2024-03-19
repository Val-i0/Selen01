package exercise16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsAndSelectDemo {
    WebDriver driver;

    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

    @Test
    public void sliderTest() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement slider = driver.findElement(By.className("form-range"));

        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider).moveByOffset(40, 0).perform();
    }

    @Test
    public void dragAndDropTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Actions drag = new Actions(driver);

        Thread.sleep(2000);

//        drag.dragAndDrop(source, target).perform();
        drag.clickAndHold(source).moveToElement(target).perform();
    }

    @Test
    public void keyPressTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/key_presses");
        WebElement target = driver.findElement(By.id("target"));

        target.sendKeys(Keys.ESCAPE);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(), "You entered: ESCAPE");
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement select = driver.findElement(By.cssSelector("select#dropdown"));

        Select dropdown = new Select(select);
        dropdown.selectByVisibleText("Option 2");
        dropdown.selectByValue("1");
    }

    @Test
    public void dropdownTest2() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
//        WebElement select = driver.findElement(By.name("my-select"));
//        WebElement select = driver.findElement(By.cssSelector("[name=my-select]"));
        WebElement select = driver.findElement(By.cssSelector("[name='my-select']"));
//        WebElement select = driver.findElement(By.cssSelector("name=\"my-select\""));

        Select dropdown = new Select(select);
        //dropdown.selectByVisibleText("Three");
//        dropdown.selectByIndex(2);
        dropdown.selectByValue("3");
    }

    @Test
    public void tableTest() {
        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement table1 = driver.findElement(By.id("table1"));
        List<WebElement> emails = driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr/td[3]"));

        for (WebElement email : emails) {
            System.out.println(email.getText());
        }

        boolean isFound = false;

        for (WebElement email : emails) {
            if (email.getText().equals("fbach@yahoo.com")) {
                isFound = true;
            }
        }

        if (isFound) {
            System.out.printf("Email found - fbach@yahoo.com");
        } else {
            System.out.println("Email NOT found");
        }
    }
}
