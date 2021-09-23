package com.libraryCT.edwin;

import com.libraryCT.utility.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.libraryCT.utility.ProjectCommons.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianLogout extends TestBase {
    @BeforeEach
    public void openUrl() {
        driver.get("https://library2.cybertekschool.com/login.html");
    }

    @Test
    public void testLibrarianLogout() {

        String loginUrl = driver.getCurrentUrl();

        // Librarian login
        userLogin(driver, "librarian22@library");

        waitFor(5);

        userLogout(driver);

        assertEquals(loginUrl, driver.getCurrentUrl());
    }
}
