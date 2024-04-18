package exercise24.base;

import exercise24.driver.DriverFactory;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MainTest {
    //public WebDriver driver;
    private String url;
    private int implicitWait;
    private String browser;

    @BeforeMethod
    public void setUp() {
        setupBrowserDriver();
        loadUrl();
    }

/*    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }*/

    private void setupBrowserDriver() {
        try (FileInputStream configFile = new FileInputStream("src/test/resources/config.properties")) {
            Properties config = new Properties();
            config.load(configFile);
            url = config.getProperty("urlAddress");
            implicitWait = Integer.parseInt(config.getProperty("implicitWait"));
            browser = config.getProperty("browser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // create diff drivers if declared here and not in DriverFactory class
/*        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unsupported browser type");
        }*/

        switch (browser) {
            case "chrome":
                DriverFactory.setChromeDriver(implicitWait);
                break;
            case "firefox":
                DriverFactory.setFirefoxDriver(implicitWait);
                break;
            default:
                throw new IllegalStateException("Unsupported browser type");
        }
    }

    private void loadUrl() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get(url);
    }

    // make screenshots if failed tests
    @AfterMethod
    public void tearDown(ITestResult result){
        WebDriver driver = DriverFactory.getDriver();

        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            String fileName = result.getName() + "_" + timestamp + ".png";

            // Add Screenshots to Allure report - path to save screenshots
            Path path = Paths.get("./Screenshots", fileName);

//            try {
//                FileUtils.copyFile(source, new File("./Screenshots/" + fileName)); // FileUtils.copyFile comes from commons.io - pom.xml dependency
//                System.out.println("Screenshot taken: " + fileName);
            try {
                Files.copy(source.toPath(), path); // Allure's syntax for saving files to path
                Allure.addAttachment("Screenshot on Failure", "image/png", Files.newInputStream(path), ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DriverFactory.quitDriver();
    }
}
