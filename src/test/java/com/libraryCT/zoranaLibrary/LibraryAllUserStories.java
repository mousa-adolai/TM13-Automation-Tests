package com.libraryCT.zoranaLibrary;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryAllUserStories {

    WebDriver driver;

    @BeforeAll
    public static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setUpBrowser(){
        driver = new ChromeDriver();
    }


    @AfterEach
    public void quitBrowser(){
        //  driver.quit();
    }

    // TODO USER STORY 1
    // As a user, I should be able to login to LibraryCT

    // AC1
    @Test
    public  void librarianLogIn(){

        // librarian is on the login page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);


        // verify that the title is Login-Library
        assertTrue(driver.getTitle().equals("Login - Library"), "title is not Login-Library");

        // when librarian enters valid email address and password
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");

        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");


        // and librarian clicks sing in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();


        // verify there are 3 models on the page
        List<WebElement> models = driver.findElements(By.className("title"));
        assertTrue(models.size() == 3, "there is no 3 models on the page");

    }

    // AC2
    @Test
    public void studentLogIn(){

        // student is on the login page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        // verify URL is https://library2.cybertekschool.com/login.html
        assertEquals(driver.getCurrentUrl(), "https://library2.cybertekschool.com/login.html", "not correct URL");


        //when students eneters valid email address and password
        driver.findElement(By.id("inputEmail")).sendKeys("student70@library");

        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");



        // and student clicks sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();


        //verify there are 2 models on the page
        List<WebElement> models = driver.findElements(By.className("title"));
        assertEquals(models.size(), 2, "there is no 2 models on the page");
    }

    // AC3
    @Test
    public void invalidLogIn() {

        // user is on the login page
        driver.get("https://library2.cybertekschool.com/login.html");

        // when user enters invalid email or password
        driver.findElement(By.id("inputEmail")).sendKeys("studen70@library");

        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("something2022*");


        // and user clicks sing in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();


        // verify the error message Sorry, Wrong Email or Password
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[2]/div"));
        String error = errorMessage.getText();
        assertTrue(errorMessage.isDisplayed());
        assertEquals(error, "Sorry, Wrong Email or Password", "error message is not matching/ not displayed");
    }


    // TODO USER STORY 2
    // As a librarian, I should be able to add a new user

    // AC1
    @Test
    public void addUser() throws InterruptedException {
        // librarian is on the home page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");

        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");

        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        // librarian clicks USERS module
        driver.findElement(By.linkText("Users")).click();


        // librarian clicks add User button
        driver.findElement(By.linkText("Add User")).click();

        // librarian enter full name, password, email and address
        //full name
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.click();
        fullName.sendKeys("Bla bla bla");
        //password
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("selenium12ss3");
        //email
        WebElement email =  driver.findElement(By.name("email"));
        email.click();
        String emailOfLastUser = "s@yyuyiygmail.com";
        email.sendKeys(emailOfLastUser);
        // adress
        WebElement address = driver.findElement(By.xpath("//*[@id=\"address\"]"));
        address.click();
        address.sendKeys("111 Huntington Street, Alexandria, 22212 Virginia");

        // librarian click save changes
        driver.findElement(By.cssSelector("button[class='btn btn-primary']")).click();

        Thread.sleep(3000);

        // verify that new user is created
        String lastUserInfo = driver.findElement(By.xpath("//*[@id=\"tbl_users\"]/tbody/tr[1]/td[4]")).getText();
        assertEquals(emailOfLastUser, lastUserInfo, "new user is not created");
    }


    // TODO USER STORY 3
    // As a librarian, I should be able to add a new book

    // AC1
    @Test
    public void addBook() throws InterruptedException {

        //librarian is on the home page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();


        // librarian clicks Book module
        driver.findElement(By.linkText("Books")).click();

        // number of books before
        String numberOfBooksBefore = driver.findElement(By.cssSelector("div[class='dataTables_info']")).getText();
        System.out.println("numberOfBooksBefore = " + numberOfBooksBefore);


        // librarian clicks +addBook button
        driver.findElement(By.xpath("//*[@id=\"books\"]/div[1]/div[1]/span/a")).click();


        // librarian enter BookName, ISBN, Year, Author, and Description
        // book name
        WebElement bookName = driver.findElement(By.cssSelector("#add_book_form > div.modal-body > div > div:nth-child(1) > div.col-6 > div > input"));
        bookName.click();
        bookName.sendKeys("Java for Dummiesss");

        // isbn
        WebElement isbn = driver.findElement(By.name("isbn"));
        isbn.click();
        isbn.sendKeys("a578");

        // year
        WebElement year = driver.findElement(By.name("year"));
        year.click();
        year.sendKeys("2012");

        // author
        WebElement author = driver.findElement(By.cssSelector("#add_book_form > div.modal-body > div > div:nth-child(2) > div:nth-child(1) > div > input"));
        author.click();
        author.sendKeys("Someone Smart");

        // description
        WebElement description = driver.findElement(By.id("description"));
        description.click();
        description.sendKeys("Java for beginners");


        // save changes
        driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[2]/button[2]")).click();
        Thread.sleep(3000);

        //number of books now
        String numberOfBooksNow = driver.findElement(By.cssSelector("div[class='dataTables_info']")).getText();


        // verify a new book is added
        assertNotEquals(numberOfBooksBefore, numberOfBooksNow);



    }


    // TODO USER STORY 4
    // As a librarian, I want to logout from the library homepage


    //AC1
    @Test
    public void librarianLogOut(){
        // user is on the home page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        // when user click username on the right top corner
        driver.findElement(By.xpath(" //span[.='Test Librarian 21']")).click();

        // and user clicks log out
        driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();

        // verify user navigate back to log in page
        assertTrue(driver.getTitle().equals("Login - Library"), "user is not on a login page");

    }


    @Test
    public void studentLogOut(){

        // user is on home page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("student91@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();


        // when user clicks username on the right top corner
        driver.findElement(By.xpath(" //*[@id=\"navbarDropdown\"]/span")).click();

        // and user clicks log out
        driver.findElement(By.xpath("//a[@class='dropdown-item']")).click();

        // verify user navigate back to login page
        assertTrue(driver.getTitle().equals("Login - Library"));

    }


    // TODO USER STORY 5
    // As a librarian, I want to select user groups

    // AC1
    @Test
    public void selectUserGroups() throws InterruptedException {
        // librarian is on the homePage
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        // librarian clicks Users module
        driver.findElement(By.linkText("Users")).click();

        // librarian click user group dropdown
        WebElement selectUserGroups = driver.findElement(By.xpath("//*[@id=\"user_groups\"]"));
        selectUserGroups.click();

        // verify librarian have 3 options
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"user_groups\"]")));
        List<WebElement> dd = dropdown.getOptions();
        assertTrue(dd.size() == (3));

        // 1. option ALL is selected
        WebElement option1 = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='null']"));
        option1.click();
        assertTrue(option1.isSelected(), "Option ALL not selected");
        String name1 = option1.getText();

        // 2. option Librarian is selected
        WebElement option2 = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='2']"));
        option2.click();
        assertTrue(option2.isSelected(), "Option Librarian not selected");
        String name2 = option2.getText();

        // 3. option Student is selected
        WebElement option3 = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='3']"));
        option3.click();
        assertTrue(option3.isSelected(), "Option Student not selected");
        String name3 = option3.getText();

        ArrayList<String> actualResult = new ArrayList<>(Arrays.asList(name1, name2, name3));
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ALL", "Librarian", "Students"));
        assertEquals(actualResult, expectedResult);
    }


    // TODO USER STORY 6
    // As a librarian, I want to select user status - active vs inactive

    // AC 1
    @Test
    public void selectUserStatus() throws InterruptedException {
        // librarian is on the homePage
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        // librarian click Users module
        driver.findElement(By.linkText("Users")).click();

        // librarian click Status dropdown
        WebElement statusDropdown = driver.findElement(By.id("user_status"));
        statusDropdown.click();

        // verify there are 2 status options
        Select dropdown = new Select(driver.findElement(By.id("user_status")));
        List<WebElement> dd = dropdown.getOptions();
        assertTrue(dd.size() == (2) );

        // 1. option Active selected
        WebElement option1 = driver.findElement(By.xpath("//*[@id=\"user_status\"]/option[1]"));
        option1.click();
        assertTrue(option1.isSelected(), "not able to select Active status");
        String option1Text1 = option1.getText();


        // 2. option Inactive selected
        WebElement option2 = driver.findElement(By.xpath("//*[@id=\"user_status\"]/option[2]"));
        option2.click();
        assertTrue(option2.isSelected(), "not able to select Inactive status");
        String option2Text2 = option2.getText();
        ArrayList<String> actualResult = new ArrayList<>(Arrays.asList(option1Text1, option2Text2));
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ACTIVE", "INACTIVE"));
        assertEquals(actualResult, expectedResult);

    }


    // TODO USER STORY 7
    // As a user, I want to filter book categories

    // AC1
    @Test
    public void filterBookCategories() {
        // user is on a home page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();


        // user click Books module
        driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[3]/a/span[1]")).click();

        // user click book category dropdown
        // driver.findElement(By.id("book_categories")).click();
        Select dropdown = new Select(driver.findElement(By.id("book_categories")));

        // verify there are 21 options
        List<WebElement> dd = dropdown.getOptions();
        assertTrue(dd.size() == (21));

        for (int i = 0; i < dd.size(); i++) {
            dd.get(i).click();
            assertTrue(dd.get(i).isSelected());
        }
    }


    // AC2
    // able to select Drama option
    @Test
    public void ableToSelectOption(){
        // user is on a home page
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();

        // user click Books module
        driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[3]/a/span[1]")).click();

        // user click book category dropdown
        driver.findElement(By.id("book_categories")).click();
        Select dropdown = new Select(driver.findElement(By.id("book_categories")));

        // verify user is able to selected the “Drama” option
        dropdown.selectByVisibleText("Drama");
        WebElement selectedDrama = driver.findElement(By.xpath("//option[.='Drama']"));
        assertTrue(selectedDrama.isSelected(), "Drama is not selected");


    }







}
