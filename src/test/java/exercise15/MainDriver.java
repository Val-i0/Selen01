package exercise15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class MainDriver {
    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @AfterMethod
    public void killDriver() {
        this.driver.quit();
    }
}
