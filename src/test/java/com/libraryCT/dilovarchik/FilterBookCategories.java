package com.libraryCT.dilovarchik;


import com.libraryCT.utility.HomePage;
import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FilterBookCategories  extends TestBase {
    @Test
    public void bookCategories(){

        //TODO: Given user is on the homePage (AC)
        // navigating user to homePage
        HomePage.homepage(driver);

        //TODO: When user click Books module (AC)
        // navigating user to Books module and click
        driver.findElement(By.xpath("//a[@href='#books']")).click();

        //TODO: And user click book category dropdown(AC)
        // navigating to book categories box and click
        driver.findElement(By.id("book_categories"));
        // selecting book options from categories

        //TODO: Then verify there are 21 options (AC)

        Select bookCategories= new Select(driver.findElement(By.id("book_categories")));
        // storing books to the List
        List<WebElement> bookOptions = bookCategories.getOptions();
        // storing total book options to variable
        int expectedResult = 21;
        // looking for actual result of book categories option
        int actualResult =bookOptions.size();
        // compare expected size to actual size of book categories
        assertEquals(expectedResult,actualResult);




    }
}
