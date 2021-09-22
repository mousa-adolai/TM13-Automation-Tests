package com.libraryCT.mousa.user_story_1_log_in_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class TC3UserLogsInWithInvalidCredentials extends TestBase {
    /*
    AC #3 [negative]:
    Given user is on the login page
    When user enters invalid email address or password
    And student click sign in button
    Then verify the error message “Sorry, Wrong Email or Password”
     */

    @Test //calls the Test interface
    public void invalidLogsIn() {
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //locate and send invalid valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("incorrect0@library");
        //locate and send invalid password to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("bad2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        //sign in complete, librarian is on homepage

        //verify the error message is displayed
        assertTrue(driver.findElement(By.xpath("//div[.='Sorry, Wrong Email or Password']")).isDisplayed());
    }
}
