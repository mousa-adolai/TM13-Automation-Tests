package com.libraryCT.utility;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected static WebDriver driver;

    // Setting up driver
    @BeforeEach
    public void driverSetup() {
        driver = WebDriverFactory.getDriver("chrome"); // Change parameter to the browser you require

        // Implicit wait to wait for elements to be found on a loading page before throwing an error
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterEach
    public void closeBrowser() {
        driver.quit();
    }
}
