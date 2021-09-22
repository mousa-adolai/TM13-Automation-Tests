package com.LibraryCTKarina.US7;

import com.LibraryCTKarina.utility.CommonClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


public class AC2 extends CommonClass {
    /*
    AC #2:
Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify user is able to selected the “Drama” option
Create total 2 test cases , 1 test execution on jira
Note: AC#1&2 are requiring to test if both Librarian & Students can use the book categories as expected. Since both
users have the SAME STEP & EXPECTED RESULT, we only need to create ONE test case for each AC.
     */


    @Test
    public void LibrarianBookCategorySelection(){
        CommonClass.login("https://library2.cybertekschool.com/login.html","librarian21@library","Sdet2022*" );
        //click on books module
        driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();//librarian click on books module
        //click on book category  dropdown
        driver.findElement(By.xpath("//select[@id= 'book_categories']")).click();
        CommonClass.bookCategoriesSelection("Drama");

    }



    @Test
    public void StudentBookCategorySelection(){
        CommonClass.login("https://library2.cybertekschool.com/login.html","student70@library","Sdet2022*" );
        //click on books module
        driver.findElement(By.xpath("//i[@class='fa fa-book']")).click();//librarian click on books module
        //click on book category  dropdown
        driver.findElement(By.xpath("//select[@id= 'book_categories']")).click();
        CommonClass.bookCategoriesSelection("Drama");
    }


}
