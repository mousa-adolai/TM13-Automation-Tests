package com.libraryCT.dilovarchik;


import com.libraryCT.utility.HomePage;
import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class SelectBookType extends TestBase {
    @Test
    public void selectDramaOption() {

        //TODO: Given user is on the homePage (AC)
        // navigating user to homePage
        HomePage.homepage(driver);

        //TODO: When user click Books module (AC)
        // navigating user to Books module and click
        driver.findElement(By.xpath("//a[@href='#books']")).click();

        //TODO: And user click book category dropdown(AC)
        // navigating to book categories box and click
        driver.findElement(By.id("book_categories"));

        //TODO: Then verify user is able to selected the “Drama” option (AC)
        // locating user to drama option
        WebElement selectDrama = driver.findElement(By.xpath("//option[.='Drama']"));
        // verifying if drama option has been selected
        selectDrama.isSelected();


    }
}