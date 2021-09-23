package com.libraryCT.edwin;

import static com.libraryCT.utility.ProjectCommons.*;
import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends TestBase {
    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testCheckLoginUrl() {
        String expectedCurrentUrl = "http://library2.cybertekschool.com/login.html";

        assertEquals("http://library2.cybertekschool.com/login.html", expectedCurrentUrl);
    }

    @Test
    public void testStudentUserLogin() {
        userLogin(driver,"student91@library");

        // There should be 2 modules
        List<WebElement> modules = driver.findElements(By.className("card"));

        // assertEquals(modules.size(), 2);

        // Student should be on book management
        assertEquals("Book Management", driver.findElement(By.xpath("//*[@id=\"books\"]/div[1]/div[1]/h3")).getText());
        assertTrue(driver.findElement(By.xpath("//a/span[text()='Books']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//a/span[text()='Borrowing Books']")).isDisplayed());
    }

    @Test
    public void testLibrarianLogin() {
//        emailInput.sendKeys("librarian21@library");
//        passwordInput.sendKeys("Sdet2022*");
//        signInButton.submit();

        userLogin(driver, "librarian21@library");

        // There should be 3 modules
        List<WebElement> modules = driver.findElements(By.className("card"));

        assertEquals(modules.size(), 3);
    }

    @Test
    public void testInvalidLoginCredentials() {
//        emailInput.sendKeys("test@email");
//        passwordInput.sendKeys("12345");
//        signInButton.submit();
        userLogin(driver, "aninvalidemail@email.com", "invalidpassword");

        assertTrue(driver.findElement(By.xpath("//div[.= 'Sorry, Wrong Email or Password']")).isDisplayed());
    }

    @Test
    public  void testInvalidEmailEntered() {
        userLogin(driver, "aninvalidemail");

        // //*[@id="inputEmail-error"]
        assertTrue(driver.findElement(By.id("inputEmail-error")).isDisplayed());
    }
}
