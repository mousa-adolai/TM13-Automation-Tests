package com.LibraryCTKarina.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommonClass extends TestBase {

    public static void login(String url, String userName, String password) {

        driver.get(url);
        driver.findElement(By.id("inputEmail")).sendKeys(userName);
        driver.findElement(By.xpath("//*[@id=\"inputPassword\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button.btn.btn-lg.btn-primary.btn-block")).click();
    }


    public static void bookCategoriesSelection(String bookCategory){

        // Im getting the list of elements and storing them on a List
        List<WebElement> elementCount = driver.findElements(By.xpath("//select[@id= 'book_categories']//option"));

        // click any value
        for(int i = 0; i < elementCount.size() ; i++){
            if ( elementCount.get(i).getText() == bookCategory){
                elementCount.get(i).click();
            }
        }

    }
}

