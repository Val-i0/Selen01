package exercise21.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Map;

public class DriverFactory {

    public static WebDriver getChromeDriver(int wait) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS); // dismiss all alerts

        //set browser to emulate a mobile viewport
//        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5");
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        return driver;
    }

    public static WebDriver getFirefoxDriver(int wait) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
        return driver;
    }
}
