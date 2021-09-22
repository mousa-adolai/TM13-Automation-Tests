package com.libraryCT.fabricio.userstories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory7Test1 {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        // click Books
        driver.findElement(By.xpath("//span[.='Books']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='book_categories']")).click();



    }
}
