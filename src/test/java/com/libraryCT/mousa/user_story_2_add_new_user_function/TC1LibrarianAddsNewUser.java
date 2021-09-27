package com.libraryCT.mousa.user_story_2_add_new_user_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class TC1LibrarianAddsNewUser extends TestBase {
    /*
    AC #1:
    Given librarian is on the home page
    When librarian click Users module
    And librarian click “+Add User” button
    When librarian enter full name, password, email and address
    And librarian click save changes
    Then verify a new user is created
     */

    @Test //calls the Test interface
    public void librarianAddsNewUser() {
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        //locate and send valid email to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        //sign in complete, librarian is on homepage

        //librarian clicks users module
        driver.findElement(By.linkText("Users")).click();
        //librarian clicks add user button
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();
        //librarian fills out the add new user form
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[1]/div/div/input")).sendKeys("Rahel Legese");//full name field
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("Ilovecybertek");//password field
        int randomNum = (int)(Math.random()*1000+Math.random()*15);
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("Ilovecybertek"+randomNum+"@cybertekschool.com");//email field
        //librarian saves changes to add new user form
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[2]/button[2]")).submit();//submit button

        //locate the most recently added user
        WebElement mostRecentUserName = driver.findElement(By.xpath("//table[@id = 'tbl_users']/tbody/tr[1]/td[3]"));
        //verify the new user has been added by checking the actual first name matches the expected
        assertEquals("Rahel Legese", mostRecentUserName.getText());


    }

}

