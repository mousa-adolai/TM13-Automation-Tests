package com.libraryCT.fabricio.userstories;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserStory2Test1 {

    public static void main(String[] args) throws InterruptedException {
/*
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
driver.get("http://library2.cybertekschool.com/login.html");
driver.manage().window().maximize();

driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();//sign in complete, librarian is on

driver.get("https://library2.cybertekschool.com/#users");
//cheat ^^^^ for now



driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sn']")).click();
driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[1]/div/div/input")).sendKeys("Rahel Legese");//full name field
driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("Ilovecybertek");//password field
driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("Ilovecybertek@cybertekschool.com");//first name field
driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[2]/button[2]")).submit();//submit button



//driver.findElement(By.xpath("//*[@id=\"menu_item\"]/li[2]/a")).click();
//driver.findElement(By.xpath("//span[.='Users']")).click();
//driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();
 */


        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");

                driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
        driver.findElement(By.id("inputPassword")).sendKeys("Sdet2022*");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Users']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='full_name']")).sendKeys("Thor Thunder");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Lightning");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("thor12345@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='address']")).sendKeys("1234 Thunder Rd");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();






    }



}

