package com.libraryCT.dilovarchik;


import static org.junit.jupiter.api.Assertions.*;


import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class LibrarianLogin extends TestBase {


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