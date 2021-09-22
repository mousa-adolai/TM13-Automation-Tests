package com.LibraryCTKarina.US3;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class AC1 extends CommonClass {

    /*
    User Story 3
As a librarian, I should be able to add a new book.
AC #1:
Given librarian is on the homePage
When librarian click Books module
And librarian click “+Add Book” button
When librarian enter BookName, ISBN, Year, Author, and Description
And librarian click save changes
Then verify a new book is added
     */

    @Test
    public void NewBookVerification(){

        CommonClass.login("https://library2.cybertekschool.com/login.html","librarian21@library","Sdet2022*" );
        // xpath: //span[@class='title']

        driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();//librarian click on books module
        driver.findElement(By.xpath("//i[@class='fa fa-plus']")).click();//librarian click "+add book"
        //librarian enter BookName, ISBN, Year, Author, and Description
        driver.findElement(By.xpath("//label[contains(text(),'Book Name')]/..//input")).sendKeys("The Holy Bible");
        driver.findElement(By.xpath("//label[contains(text(),'ISBN')]/..//input")).sendKeys("12345677");
        driver.findElement(By.xpath("//label[contains(text(),'Year')]/..//input")).sendKeys("30");
        driver.findElement(By.xpath("//label[contains(text(),'Author')]/..//input")).sendKeys("God");
        driver.findElement(By.xpath("//label[contains(text(),'Description')]/..//textarea")).sendKeys("This book will give you the support when needed, the strength in the weakness");
        driver.findElement(By.xpath("//button[contains(text(),'Save changes')]")).click();//librarian click to add  book
        driver.findElement(By.xpath("//div[contains(text(),'The book has been created')]")).isDisplayed();//librarian click to add  book
        //asserting that the object(book) it has been created
        assertTrue(driver.findElement(By.xpath("//div[contains(text(),'The book has been created')]")).isDisplayed());


    }
}
