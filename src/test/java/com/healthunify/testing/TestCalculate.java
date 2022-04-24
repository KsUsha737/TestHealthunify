package com.healthunify.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculate {//вес в кг., рост в см.
    @Test
    public void testCalculate() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("60");
        driver.findElement(By.xpath("//p/select[@name='opt1']")).click();
        driver.findElement(By.xpath("//p/select[@name='opt1']/option[@value='kilograms']")).click();
        driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("160");
        driver.findElement(By.xpath("//p/input[@name='cc']")).click();
        String name=driver.findElement(By.xpath("//td/input[@class='resform'][@name='si']")).getAttribute("value");
        Assert.assertEquals(name, "23.44");
//        driver.close();
    }
}
