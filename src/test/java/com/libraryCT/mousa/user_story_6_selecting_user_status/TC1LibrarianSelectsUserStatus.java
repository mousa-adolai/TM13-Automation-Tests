package com.libraryCT.mousa.user_story_6_selecting_user_status;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TC1LibrarianSelectsUserStatus extends TestBase {
    @Test
    public void librarianSelectsUserStatus() {
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        //locate and send valid email to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        //librarian clicks users module
        driver.findElement(By.linkText("Users")).click();
        List<WebElement> list = driver.findElements(By.cssSelector("select#user_status>option"));
        assertEquals(2, list.size());

    }
}
