package com.LibraryCTKarina.US5;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC1 extends CommonClass {

    /*
    User Story 5
As a librarian, I want to select user groups.
AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click user group dropdown
Then verify librarian have 3 options
     */

    @Test
    public void LibrarianGroupsDropdown(){
        CommonClass.login("https://library2.cybertekschool.com/login.html", "librarian21@library", "Sdet2022*");
        driver.findElement(By.xpath("//span[contains(text(),'Users')]")).click();// clicks on user's module
        //click on user group dropdown
        driver.findElement(By.xpath("//select[@id='user_groups']")).click();
        //verify that 3 options are displayed
        assertTrue(driver.findElement(By.xpath("//option[contains(text(),'ALL')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//option[contains(text(),'Librarian')]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//option[contains(text(),'Students')]")).isDisplayed());
    }
}
