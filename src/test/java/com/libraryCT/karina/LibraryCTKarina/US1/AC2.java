package com.LibraryCTKarina.US1;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AC2 extends CommonClass {

    /*
    AC#2:
Given student is on the loginPage
Then verify that the URL is
 “https://library2.cybertekschool.com/login.html”
When student enters valid email address and password
And student click sign in button
Then verify that there are 2 models on the page
     */

@Test
public void StudentPageVerification(){

    //Login-in as a Student.
    CommonClass.login("https://library2.cybertekschool.com/login.html","student70@library","Sdet2022*" );
    //Verifying user land to the student page.
    String expectedUrl = "https://library2.cybertekschool.com/login.html" ;
    String actualUrl = driver.getCurrentUrl();
    assertEquals(expectedUrl,actualUrl ) ;
    // verify that there are 2 modules on the page
    assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Books')]")).isDisplayed());
    assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Borrowing Books')]")).isDisplayed());
}


}
