package com.LibraryCTKarina.US2;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC1 extends CommonClass {

    /*
    As a librarian, I should be able to add a new user.
AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click “+Add User” button
When librarian enter full name, password, email and
address
And librarian click save changes
Then verify a new user is created
Note: To add new user, the date part automation is not covered
yet, you can skip it
     */


    @Test
    public void LibrarianAddNewUser(){

        Random rand = new Random();
       // Obtain a number between [0 - 49].
        int randomNumber = rand.nextInt(50);

        String fullName = "clarinaAutomation";
        // Login as a librarian
        CommonClass.login("https://library2.cybertekschool.com/login.html","librarian21@library","Sdet2022*" );
        driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();//add user button
        driver.findElement(By.xpath("//label[contains(text(),'Full Name')]/..//input")).sendKeys(fullName);//full name field
        driver.findElement(By.xpath("//label[contains(text(),'Password')]/..//input")).sendKeys("Ilovecybertek");//password field
        driver.findElement(By.xpath("//label[contains(text(),'Email')]/..//input")).sendKeys(randomNumber +"Iloveybertek@cybertekschool.com");//Random number since email need to be unique every time :)
        driver.findElement(By.xpath("//*[contains(text(),'Save changes')]")).submit();//submit button

        //verify a new user is created
        assertTrue(driver.findElement(By.xpath(" //div[@id='toast-container']")).isDisplayed());
        assertEquals(fullName,driver.findElement(By.xpath("//tr[@class='odd'][1]//td[3]")).getText());

    }
}
