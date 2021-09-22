package com.libraryCT.mousa.user_story_3_add_new_book_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC1LibrarianAddsNewBook extends TestBase {
    /*
    AC #1:
    Given librarian is on the home page
    When librarian click Books module
    And librarian click “+Add Book” button
    When librarian enters BookName, ISBN, Year, Author, and Description
    And librarian click save changes
    Then verify a new book is created
     */

    @Test //calls the Test interface
    public void librarianAddsNewBook() {
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        //locate and send valid email to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        //sign in complete, librarian is on homepage

        //librarian clicks books module
        driver.findElement(By.linkText("Books")).click();
        //librarian clicks add book button
        driver.findElement(By.partialLinkText("Add Book")).click();
        //librarian fills out the add new user form
        driver.findElement(By.name("name")).sendKeys("The Secret");//book name field
        driver.findElement(By.name("isbn")).sendKeys("12345678");//isbn field
        driver.findElement(By.name("year")).sendKeys("2006");//year field
        driver.findElement(By.cssSelector("input[name = 'author']")).sendKeys("Rhonda Byrne");//author field
        driver.findElement(By.tagName("textarea")).sendKeys("This is a good book about a different, rewarding, but potentially dangerous view on life");
        driver.findElement(By.xpath("//button[.='Save changes']")).click();
       //librarian created a book

        //search for the book just created to verify it is creates
       // driver.findElement(By.cssSelector("input[type='search']")).sendKeys("The Secret");

        //locate the most recently added user
       // WebElement mostRecentUserName = driver.findElement(By.xpath("//table[@id = 'tbl_books']/tbody/tr[1]/td[3]"));
        //verify the new user has been added by checking the actual first name matches the expected
        //System.out.println("mostRecentUserName.getText() = " + mostRecentUserName.getText());
        //assertEquals("The Secret", mostRecentUserName.getText());
        assertTrue(driver.findElement(By.xpath("//div[contains(text(),'The book has been created')]")).isDisplayed());


    }

}

