package com.libraryCT.dilovarchik;

import Utility.BrowserUtil;
import Utility.TestBase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddingNewUserByLibrarian extends TestBase {

    @Test
    public void librarianOnHomePage(){

        //TODO: Given librarian is on the homePage (AC)
        // location title element
        WebElement homePageTitle = driver.findElement(By.xpath("//title[.='Library']"));
        // locating expected title
        String expectedResult = "Library";
        // verifying if actual result is matching with expected result
        assertEquals(expectedResult,driver.getTitle());

    }

    @Test
    public void addNewUser(){

        //TODO: When librarian click Users module(AC)

        // locating users module and click
        driver.findElement(By.xpath("//span[.='Users']")).click();

        //TODO: And librarian click “+Add User” button(AC)

        // locating add new user button and click
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();

        //TODO: When librarian enter full name, password, email and address(AC)
        BrowserUtil.waitFor(1);
        // locating full name input box
        WebElement fullName = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        // entering full name
        fullName.sendKeys("Dilik Kh");
        BrowserUtil.waitFor(1);
        //locating password input box
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        //entering password
        password.sendKeys("Khomdidov@87");
        BrowserUtil.waitFor(1);
        // locating email input box
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        //entering email
        email.sendKeys("khomidov1@gmail.com");
        BrowserUtil.waitFor(1);
        // locating address input box
        WebElement address = driver.findElement(By.xpath("//textarea[@id='address']"));
        // entering address
        address.sendKeys("268 Parlin ST, Dover,DE");
        BrowserUtil.waitFor(2);

        //TODO: And librarian click save changes (AC)
        //locating save changes and click it
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //TODO:Then verify a new user is created Note: (AC)

        // locating text message
        WebElement newUser = driver.findElement(By.xpath("//div[@class='toast-message']"));
        // printing text message
        System.out.println("newUser.getText() = " + newUser.getText());
        // verifying if the text message has been displayed
        assertTrue(newUser.isDisplayed());



    }


}