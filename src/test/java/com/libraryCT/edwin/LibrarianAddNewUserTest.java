package com.libraryCT.edwin;

import com.libraryCT.utility.ProjectCommons;
import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.libraryCT.utility.ProjectCommons.userLogin;
import static com.libraryCT.utility.ProjectCommons.waitFor;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianAddNewUserTest extends TestBase {
    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testLibrarianAddNewUser() {
        // Login
        userLogin(driver, "librarian21@library");

        driver.findElement(By.xpath("//span[.= 'Users'][@class = 'title'] ")).click();

        // Open add user form
        driver.findElement(By.xpath("//a[.= ' Add User'][@href = 'tpl/add-user.html'][@class]")).click();


        // Enter data
        // WebElement fullNameInput = driver.findElement(By.xpath("//div/input[name='full_name'][type='text']"));
        WebElement fullNameInput = driver.findElement(By.cssSelector("#add_user_form > div.modal-body > div > div:nth-child(1) > div > div > input"));

        // WebElement passwordInput = driver.findElement(By.xpath("input[type='password'][name='password']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("#add_user_form > div.modal-body > div > div:nth-child(2) > div:nth-child(1) > div > input"));

        // WebElement emailInput = driver.findElement(By.xpath("input[name='email'][type='text']"));
        WebElement emailInput = driver.findElement(By.cssSelector("#add_user_form > div.modal-body > div > div:nth-child(2) > div:nth-child(2) > div > input"));

        WebElement addressInput = driver.findElement(By.cssSelector("#address"));

        // Test data
        String full_name = "Brandylee Money";
        String password = "6mnjChKqfMxExJ";
        String email = "brandyleemoney@library";
        String address = "Agent Road 3115, Ubly, Benin, 411232";

        // Test data input
        addressInput.sendKeys(address);
        fullNameInput.sendKeys(full_name);
        passwordInput.sendKeys(password);
        emailInput.sendKeys(email);

        // Submit the test data
        driver.findElement(By.cssSelector("#add_user_form > div.modal-footer > button.btn.btn-primary")).submit();

        waitFor(5); // Wait for test data to submit & reload

        WebElement nameInTable = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")); // Get latest name
        WebElement emailInTable = driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")); // Get latest email

        assertEquals(full_name, nameInTable.getText());
        assertEquals(email, emailInTable.getText());
    }
}
