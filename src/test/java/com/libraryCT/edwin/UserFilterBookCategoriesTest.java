package com.libraryCT.edwin;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static com.libraryCT.utility.ProjectCommons.userLogin;
import static com.libraryCT.utility.ProjectCommons.waitFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserFilterBookCategoriesTest extends TestBase {
    static WebElement book_categories_dropdown;
    static Select book_categories_select;

    static void getSelect() {
        // Open books module
        driver.findElement(By.xpath("//span[.='Books']")).click();

        // Find drop down
        book_categories_dropdown = driver.findElement(By.id("book_categories"));
        book_categories_select = new Select(book_categories_dropdown);
    }

    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testStudentFilterBooksOptionsAreAvailable() {
        // Login
        userLogin(driver, "student92@library");

        // Setup
        getSelect();

        // Get all select options
        List<WebElement> book_categories_select_options = new ArrayList<>(book_categories_select.getOptions());

        // Assertions
        assertEquals(21, book_categories_select_options.size());
    }

    @Test
    public void testLibrarianFilterBooksOptionsAreAvailable() {
        // Login
        userLogin(driver, "librarian22@library");

        // Setup
        getSelect();

        // Get all select options
        List<WebElement> book_categories_select_options = new ArrayList<>(book_categories_select.getOptions());

        // Assertions
        assertEquals(21, book_categories_select_options.size());
    }

    @Test
    public void testStudentIsAbleToSelectAnOption() {
        // Login
        userLogin(driver, "student91@library");

        // Setup
        getSelect();

        // Select Drama
        book_categories_select.selectByVisibleText("Drama");

        waitFor(3);

        // Assertions
        assertEquals("Drama", driver.findElement(By.xpath("//*[@id='tbl_books']/tbody/tr[1]/td[5]")).getText());
        assertEquals("Drama", driver.findElement(By.xpath("//*[@id='tbl_books']/tbody/tr[3]/td[5]")).getText());
        assertEquals("Drama", driver.findElement(By.xpath("//*[@id='tbl_books']/tbody/tr[7]/td[5]")).getText());
    }

    @Test
    public void testLibrarianIsAbleToSelectAnOption() {
        // Login
        userLogin(driver, "librarian21@library");

        // Setup
        getSelect();

        // Select Drama
        book_categories_select.selectByVisibleText("Drama");

        waitFor(3);

        // Assertions
        assertEquals("Drama", driver.findElement(By.xpath("//*[@id='tbl_books']/tbody/tr[1]/td[5]")).getText());
        assertEquals("Drama", driver.findElement(By.xpath("//*[@id='tbl_books']/tbody/tr[3]/td[5]")).getText());
        assertEquals("Drama", driver.findElement(By.xpath("//*[@id='tbl_books']/tbody/tr[7]/td[5]")).getText());
    }
}
