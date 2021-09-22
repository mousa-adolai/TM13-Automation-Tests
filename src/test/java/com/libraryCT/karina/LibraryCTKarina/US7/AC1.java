package com.LibraryCTKarina.US7;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC1 extends CommonClass {

    /*
    User Story 7
As a user, I want to filter book categories.
AC #1:
Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify there are 21 options
     */

    @Test
    public void BookModuleVerification(){
        CommonClass.login("https://library2.cybertekschool.com/login.html","librarian21@library","Sdet2022*" );
        //click on books module
        driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();//librarian click on books module
        //click on book category  dropdown
        driver.findElement(By.xpath("//select[@id= 'book_categories']")).click();

        // Im getting the list of elements and storing them on a List
        int  actual = driver.findElements(By.xpath("//select[@id= 'book_categories']//option")).size();
        int expected = 21;
        // Verifying the list contains 21 and match with expected.
        assertEquals(expected, actual);
    }
}
