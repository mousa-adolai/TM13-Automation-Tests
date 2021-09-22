package com.LibraryCTKarina.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * We need a utility class with method
 * to get WebDriver object with all the settings needed
 * by passing browserName
 *
 * WebDriverFactory.get("chrome") ==>> WebDriver object with Chrome Driver
 * WebDriverFactory.get("firefox") ==>> WebDriver object with FireFox Driver
 *  *
 */
public class WebDriverFactory{


    public static WebDriver getDriver(String browserName) {

        WebDriver driver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            // other browsers omitted
            default:
                driver = null;
                System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
        }

        driver.manage().window().maximize();

        return driver;
    }
}
