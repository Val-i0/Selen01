package exercise24.driver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver () {
        return tlDriver.get();
    }

    public static void setChromeDriver(int wait) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS); // dismiss all alerts

        //set browser to emulate a mobile viewport
//        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5");
//        options.setExperimentalOption("mobileEmulation", mobileEmulation);

//        options.addArguments("headless=true"); // headless browser - does not start ui

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        tlDriver.set(driver); // add driver to tlDriver
//        return driver;
    }

    public static void setFirefoxDriver(int wait) {
        FirefoxOptions options = new FirefoxOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS); // dismiss all alerts
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

        tlDriver.set(driver);
        // return driver;
    }

    public static void quitDriver () {
        if(tlDriver.get() != null) {
            tlDriver.get().quit();
            tlDriver.remove();
        }
    }
}
