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

public class LibrarianSelectUserGroupsTest extends TestBase {
    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testLibrarianCanAccessUserGroups() {
        // Login
        userLogin(driver, "librarian22@library");

        // Navigate to users page
        driver.findElement(By.xpath("//span[.='Users']")).click();

        // Get user groups drop down element
        WebElement user_groups_dropdown = driver.findElement(By.id("user_groups"));

        // Initialize select object
        Select user_groups_select = new Select(user_groups_dropdown);

        // Get all select options
        List <WebElement> user_groups_select_options = new ArrayList<>(user_groups_select.getOptions());

        //Assertions
        assertEquals(3, user_groups_select_options.size()); // There should be 3 options
    }
}
