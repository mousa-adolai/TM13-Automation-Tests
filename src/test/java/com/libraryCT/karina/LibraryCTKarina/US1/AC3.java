package com.LibraryCTKarina.US1;

import com.LibraryCTKarina.utility.CommonClass;
import com.LibraryCTKarina.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC3 extends TestBase {

    /*
AC #3 [negative]:
Given user is on the loginPage
When user enters invalid email address or password
And student click sign in button
Then verify the error message “Sorry, Wrong Email or Password”
     */



        @Test
        public void IncorrectCredentials () {

            //Invalid login
            CommonClass.login("https://library2.cybertekschool.com/login.html", "Invalid", "Invalid");
            //verify the error message
            assertTrue(driver.findElement(By.xpath("//div[@id='inputEmail-error']")).isDisplayed());
        }
    }