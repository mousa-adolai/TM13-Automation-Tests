package com.libraryCT.mousa.user_story_4_logout_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;


public class TC1UserLogsOut extends TestBase {

    @Test
    public void userLogsOut(){
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        //locate and send valid email to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        driver.findElement(By.linkText("Test Librarian 21")).click();
        driver.findElement(By.linkText("Log Out")).click();

        assertEquals("Login - Library", driver.getTitle());
    }
}
