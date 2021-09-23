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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianViewActiveAndInactiveUsersTest extends TestBase {
    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testLibrarianActiveAndInactiveUsersView() {
        userLogin(driver, "librarian22@library"); // Login

        // Navigate to user page
        driver.findElement(By.xpath("//span[text()='Users']")).click();

        // Find dropdown element
        WebElement user_status_elm = driver.findElement(By.id("user_status"));
        Select user_status_select = new Select(user_status_elm);

        List<WebElement> select_options = new ArrayList<>(user_status_select.getOptions());

        assertEquals("ACTIVE", select_options.get(0).getText());
        assertEquals("INACTIVE", select_options.get(1).getText());
    }
}
