package com.libraryCT.fabricio.userstories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory3Test1 {

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
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Adding Book");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='isbn']")).sendKeys("12345");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='year']")).sendKeys("2021");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='author']")).sendKeys("Stephen King");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='description']"))
                .sendKeys("Adding the book on cybertekschool.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();







    }

}
