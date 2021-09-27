package com.libraryCT.dilovarchik;

import com.libraryCT.utility.HomePage;
import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddingNewBookByLibrarian extends TestBase {


    @Test
    public void homePage(){

        //TODO: Given librarian is on the homePage(AC)

        // verifying user is on homepage by homepage method
        HomePage.homepage(driver);

    }


    @Test
    public void addNewBook(){

        //   TODO: When librarian click Books module (AC)
        // navigate Books module and click
        driver.findElement(By.xpath("//span[.='Books']")).click();

        //   TODO: And librarian click “+Add Book” button (AC)
        // navigate to "+Add Book" button and click
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")).click();

        //   TODO: When librarian enter BookName, ISBN, Year, Author, and Description (AC)
        // navigate book input box and enter book name
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("USA");

        // navigate isbn input box and enter  isbn
        driver.findElement(By.xpath("//input[@placeholder='ISBN']")).sendKeys("12345");

        // navigate year input box and enter year
        driver.findElement(By.xpath("//input[@placeholder='Year']")).sendKeys("2019");

        // navigate to Author input box and enter name
        driver.findElement(By.xpath("//input[@placeholder='Author']")).sendKeys("Trump");

        // navigate to description input box and enter description
        driver.findElement(By.id("description")).sendKeys("In God we trust");

        // TODO: And librarian click save changes
        // navigate to  save changes and click
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //TODO: Then verify a new book is added
        // locating text message
        WebElement newUser = driver.findElement(By.xpath("//div[@class='toast-message']"));
        // printing text message
        System.out.println("newUser.getText() = " + newUser.getText());
        // verifying if the text message has been displayed
        assertTrue(newUser.isDisplayed());

        //BrowserUtil.waitFor(3);















    }







}
