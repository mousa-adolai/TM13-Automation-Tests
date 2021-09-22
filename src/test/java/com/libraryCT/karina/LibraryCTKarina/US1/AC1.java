package com.LibraryCTKarina.US1;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.*;

public class AC1 extends CommonClass {
/*
     AC #1:
Given librarian is on the loginPage
Then verify that the title is “Login - Library”
When librarian enters valid email address and password
And librarian click sign in button
Then verify that there are 3 models on the page.

     */

 @Test
 public void LibrarianPageVerification(){

     //Login-in as a librarian.
     CommonClass.login("https://library2.cybertekschool.com/login.html","librarian21@library","Sdet2022*" );
     //Verifying user land to the librarian page.
     String expectedTitle = "Login - Library" ;
     String actualTitle = driver.getTitle();
     assertEquals(expectedTitle,actualTitle ) ;
     // verify that there are 3 modules on the page
     assertTrue(driver.findElement(By.xpath("//*[@id='user_count']")).isDisplayed());
     assertTrue(driver.findElement(By.xpath("//*[@id='book_count']")).isDisplayed());
     assertTrue(driver.findElement(By.xpath("//*[@id='borrowed_books']")).isDisplayed());
}
}
