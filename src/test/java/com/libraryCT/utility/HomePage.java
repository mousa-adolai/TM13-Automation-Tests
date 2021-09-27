package com.libraryCT.utility;

import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends TestBase{


    public static <WebElement> void homepage(WebDriver driver){
       // WebElement homePageTitle = driver.findElement(By.xpath("//title[.='Library']"));
        String expectedTitle ="Library";
        String actualTitle = driver.getTitle();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        assertEquals(expectedTitle,actualTitle);
    }
}
