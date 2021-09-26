package com.libraryCT.dilovarchik;

import Utility.TestBase2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginWithInvalidCredentials extends TestBase2 {

    @Test
    public void loginPage(){
        // TODO: Given student is on the loginPage(AC)

        String actualResult = driver.getTitle();
        String expectedResult = "Login - Library";

        assertEquals(expectedResult, actualResult);
    }
    @Test
    public void invalidLogin(){
        //TODO:  When user enters invalid email address or password (AC)
        // location usernameBox by xpath
        WebElement username = driver.findElement(By.xpath("//input[@id='inputEmail']"));
        username.sendKeys("librarian1213@library");
        //location passwordBox by Xpath
        WebElement password = driver.findElement(By.xpath("//input[@id='inputPassword']"));
        password.sendKeys("Sdet2022*!");

        //TODO:And student click sign in button (AC)
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        BrowserUtil.waitFor(2);

        //TODO:Then verify the error message “Sorry, Wrong Email or Password” ** (AC)

        // locating to alert text by xpath
        WebElement alertText = driver.findElement(By.xpath("//div[.='Sorry, Wrong Email or Password']"));
        //storing expected result to variable
        String expectedResult = "Sorry, Wrong Email or Password";
        // verifying if actual result is matching with expected result
        assertEquals(expectedResult,alertText.getText());







    }




}