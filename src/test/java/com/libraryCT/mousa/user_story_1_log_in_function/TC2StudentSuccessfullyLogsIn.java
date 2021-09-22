package com.libraryCT.mousa.user_story_1_log_in_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class TC2StudentSuccessfullyLogsIn extends TestBase {
    /*
    AC #2:
    Given student is on the login page
    Then verify that the URL is “https://library2.cybertekschool.com/login.html”
    When student enters valid email address and password
    And student click sign in button
    Then verify that there are 2 models on the page
     */

    @Test //calls the Test interface
    public void studentLogsIn() {
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //verify the url is correct
        assertEquals("https://library2.cybertekschool.com/login.html",driver.getCurrentUrl());
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("student70@library");
        //locate and send valid password to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        //sign in complete, librarian is on homepage

        //verify that there are two modules on the home page
        assertEquals(2,driver.findElements(By.cssSelector("ul#menu_item>li.nav-item")).size());
    }
}
