package com.LibraryCTKarina.US6;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC1 extends CommonClass {

    /*
    User Story 6
As a librarian, I want to select user status - active vs inactive.
AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click Status dropdown
Then verify there are 2 status options
     */

    @Test
    public void LibrarianStatusVerification(){
        CommonClass.login("https://library2.cybertekschool.com/login.html", "librarian21@library", "Sdet2022*");
        driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();// clicks on users module
       //click on user Status  dropdown
        driver.findElement(By.xpath("//select[@id= 'user_status']")).click();
        //verify that 2 options are displayed
        assertTrue(driver.findElement(By.xpath("//select[@id= 'user_status']//option[1]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//select[@id= 'user_status']//option[2]")).isDisplayed());
    }
}
