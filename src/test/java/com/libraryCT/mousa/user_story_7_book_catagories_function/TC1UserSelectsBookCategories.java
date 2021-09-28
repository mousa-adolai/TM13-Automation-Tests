package com.libraryCT.mousa.user_story_7_book_catagories_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class TC1UserSelectsBookCategories extends TestBase {

    @Test
    public void verify21BookCategories(){
        //go to QA env
        driver.get("https://library2.cybertekschool.com/");
        //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        //locate and send valid email to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
        //sign in complete, librarian is on homepage

        //librarian clicks books module
        driver.findElement(By.linkText("Books")).click();

        List<WebElement> list = driver.findElements(By.cssSelector("select#book_categories>option"));
        assertEquals(21, list.size());

    }
}
