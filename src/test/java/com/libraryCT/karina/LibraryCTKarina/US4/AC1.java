package com.LibraryCTKarina.US4;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AC1 extends CommonClass {

    /*
    User Story 4
As a librarian, I want to logout from the library homepage.
AC #1:
Given user is on the homePage
When user click username on the right top corner
And user click Log Out
Then verify user navigate back to login page.
     */
@Test
    public void LogOutVerification() {
    CommonClass.login("https://library2.cybertekschool.com/login.html", "librarian21@library", "Sdet2022*");
    String expectedTitle = "Login - Library";
    String actualTitle = driver.getTitle();
    assertEquals(expectedTitle, actualTitle);
    driver.findElement(By.xpath("//span[contains(text(),'Test Librarian 21')]")).click();//librarian click on Test Librarian21
    driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();//librarian click on logOut
    //verify that the librarian lands at home page
    String expectedHomeTitle = "Login - Library";
    String actualHomeTitle = driver.getTitle();
    assertEquals(expectedHomeTitle, actualHomeTitle);
}
}
