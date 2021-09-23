package com.libraryCT.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectCommons {
    private static WebElement emailInput, passwordInput, signInButton;
    public static String password = "Sdet2022*";

    public static void userLogin(WebDriver driver, String user_email) {
        emailInput = driver.findElement(By.cssSelector("#inputEmail"));
        passwordInput = driver.findElement(By.cssSelector("#inputPassword"));
        signInButton = driver.findElement(By.cssSelector("#login-form > button"));

        emailInput.sendKeys(user_email);
        passwordInput.sendKeys(password);
        signInButton.submit();
    }

    public static void userLogin(WebDriver driver, String user_email, String password) {
        emailInput = driver.findElement(By.cssSelector("#inputEmail"));
        passwordInput = driver.findElement(By.cssSelector("#inputPassword"));
        signInButton = driver.findElement(By.cssSelector("#login-form > button"));

        emailInput.sendKeys(user_email);
        passwordInput.sendKeys(password);
        signInButton.submit();
    }

    public static void userLogout(WebDriver driver) {
        driver.findElement(By.xpath("//*[@id='navbarDropdown']/span")).click();

        driver.findElement(By.xpath("//a[.='Log Out']")).click();
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep((long) seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
