package com.libraryCT.mousa.user_story_1_log_in_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static org.junit.jupiter.api.Assertions.*;

public class TC1LibrarianSuccessfullyLogsIn extends TestBase {
    /*
    AC #1:
    Given librarian is on the loginPage
    Then verify that the title is “Login - Library”
    When librarian enters valid email address and password
    And librarian click sign in button
    Then verify that there are 3 modules on the page
     */

    @Test //calls the Test interface
    public void librarianLogsIn() {
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //verify the title is correct
        assertEquals("Login - Library",driver.getTitle());
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        //locate and send valid password to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        //sign in complete, librarian is on homepage

        //verify that there are three modules on the home page
        assertEquals(3,driver.findElements(By.cssSelector("ul#menu_item>li.nav-item")).size());
    }
}
