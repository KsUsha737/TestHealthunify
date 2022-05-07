package com.healthunify.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHeightFootToCMSConversion {

    @Test
    public void testHeightFootToCMSConversion() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//p/select[@name='opt2']")).sendKeys("5");
        driver.findElement(By.xpath("//p/select[@name='opt3']")).sendKeys("8");
        String value = driver.findElement(By.xpath("//p/input[@class='innerc resform']")).getAttribute("value");
        Assert.assertEquals(value, "173");
        driver.close();
    }
}
