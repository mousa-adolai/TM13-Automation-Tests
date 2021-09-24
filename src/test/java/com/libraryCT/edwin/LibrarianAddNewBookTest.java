package com.libraryCT.edwin;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.libraryCT.utility.ProjectCommons.userLogin;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibrarianAddNewBookTest extends TestBase {
    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testLibrarianAddNewBook() throws InterruptedException {
        // Login
        userLogin(driver, "librarian22@library");

        // Go to books page
        driver.findElement(By.linkText("Books")).click();

        // Click the add button
        driver.findElement(By.xpath("//*[@id=\"books\"]/div[1]/div[1]/span/a")).click();

        // Identify input elements
        WebElement bookNameInput = driver.findElement(By.name("name")); // #add_book_form > div.modal-body > div > div:nth-child(1) > div.col-6 > div > input
        WebElement isbnInput = driver.findElement(By.name("isbn")); // #add_book_form > div.modal-body > div > div:nth-child(1) > div:nth-child(2) > div > input
        WebElement yearInput = driver.findElement(By.name("year")); // #add_book_form > div.modal-body > div > div:nth-child(1) > div:nth-child(3) > div > input
        WebElement authorInput = driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input")); // #add_book_form > div.modal-body > div > div:nth-child(2) > div:nth-child(1) > div > input
        WebElement bookDescriptionInput = driver.findElement(By.cssSelector("#description")); // name = description

        // Random to input
        String book_name = "Mar Mela";
        String isbn_number = "0-9390-3673-12";
        String year_of_release = "2013";
        String authors_name = "Darry Kinsler";
        String book_description = "Nurse strengths costume obtaining background bio smell, worldwide bruce recipients dentists army bald trainers.";

        // Input data
        bookNameInput.click();
        bookNameInput.sendKeys(book_name);

        isbnInput.click();
        isbnInput.sendKeys(isbn_number);

        yearInput.click();
        yearInput.sendKeys(year_of_release);

        authorInput.click();
        authorInput.sendKeys(authors_name);

        bookDescriptionInput.click();
        bookDescriptionInput.sendKeys(book_description);

        // Submit
        driver.findElement(By.xpath("//button[.='Save changes']")).click();

        Thread.sleep(5000);

        WebElement search_box = driver.findElement(By.xpath("//*[@id=\"tbl_books_filter\"]/label/input"));

        search_box.sendKeys(book_name);
        Thread.sleep(3000);

        WebElement bookNameInTable =  driver.findElement(By.xpath("//*[@id=\"tbl_books\"]/tbody/tr/td[3]"));
        WebElement bookIsbnInTable = driver.findElement(By.xpath("//*[@id=\"tbl_books\"]/tbody/tr/td[2]"));

        // Assert
        assertTrue(driver.findElement(By.xpath("//a[contains(@href, 'javascript:void(0)')]")).isDisplayed());
        assertEquals(book_name, bookNameInTable.getText());
        assertEquals(isbn_number, bookIsbnInTable.getText());

        // Assertions might have an issue

    }
}
