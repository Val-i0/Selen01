package demo1;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SeleniumDemo {
    WebDriver driver;

    @BeforeSuite
    public void bs() {
        System.out.println("BeforeSuite");
    }
    @BeforeTest
    public void bt() {
        System.out.println("BeforeTest");
    }
    @BeforeClass
    public void bc() {
        System.out.println("BeforeClass");
    }
    @BeforeMethod
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        System.out.println("BeforeMethod");
    }

    @Test
    public void test0PenBrowser() {

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button"));

        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("AfterMethod");
    }
    @AfterClass
    public void ac() {
        System.out.println("AfterClass");
    }

    @AfterTest
    public void at() {
        System.out.println("AfterTest");
    }
    @AfterSuite
    public void as() {
        System.out.println("AfterSuite");
    }
}
