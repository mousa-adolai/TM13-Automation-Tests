package com.libraryCT.dilovarchik;


import com.libraryCT.utility.HomePage;
import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianLogout extends TestBase {

    @Test
    public void logout(){

        //TODO:Given user is on the homePage(AC)
        HomePage.homepage(driver);

        //TODO: When user click username on the right top corner

        // locate username on the top right and click
        driver.findElement(By.id("navbarDropdown")).click();
        //BrowserUtil.waitFor(2);
        //TODO: And user click Log Out
        //locate log out and click
        driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();

        // TODO: Then verify user navigate back to login page(AC)
        // store expected URL
        String expectedUrl = "https://library2.cybertekschool.com/login.html";
        // compare expected url and actual Url
        assertEquals(expectedUrl, driver.getCurrentUrl());





    }
}
