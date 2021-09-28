package com.libraryCT.mousa.user_story_7_book_catagories_function;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC2UserSelectsDramaFromBookCategories extends TestBase {

    @Test
    public void librarianSelectsDramaBookCategory(){
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

        WebElement bookCategories = driver.findElement(By.cssSelector("select#book_categories"));
        WebElement dramaCategory = driver.findElement(By.cssSelector("select#book_categories>option[value='6']"));
        Select bookCategoriesDropDown = new Select(bookCategories);
        bookCategoriesDropDown.selectByVisibleText("Drama");
        assertTrue(dramaCategory.isSelected());

    }
}
