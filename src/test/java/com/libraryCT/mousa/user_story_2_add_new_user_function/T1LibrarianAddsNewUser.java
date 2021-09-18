package com.libraryCT.mousa.user_story_2_add_new_user_function;

import com.libraryCT.utility.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class T1LibrarianAddsNewUser extends TestBase {

   @Test //calls the Test interface
   public void librarianAddsNewUser(){

       //locate and send valid email to email input bar
        driver.findElement(By.id("inputEmail")).sendKeys("librarian21@library");
       //locate and send valid email to password input bar
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys("Sdet2022*");
        //press sign in button
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
       //sign in complete, librarian is on homepage



        driver.findElement(By.xpath("//a[@class='btn btn-lg btn-outline btn-primary btn-sm']")).click();//add user button
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[1]/div/div/input")).sendKeys("Rahel Legese");//full name field
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[2]/div[1]/div/input")).sendKeys("Ilovecybertek");//password field
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[1]/div/div[2]/div[2]/div/input")).sendKeys("Ilovecybertek@cybertekschool.com");//first name field
        driver.findElement(By.xpath("//*[@id=\"add_user_form\"]/div[2]/button[2]")).submit();//submit button


    }

}

