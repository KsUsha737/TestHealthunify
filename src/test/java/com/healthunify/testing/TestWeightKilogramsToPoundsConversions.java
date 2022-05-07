package com.healthunify.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestWeightKilogramsToPoundsConversions {//при условии округления до целого числа)
    @Test
    public void testKilogramsToPoundsConversions() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        driver.findElement(By.xpath("//p/select[@name='opt1']")).sendKeys("kilograms");
        driver.findElement(By.xpath("//p/input[@name='wg']")).sendKeys("60");
        driver.findElement(By.xpath("//p/select[@name='opt1']")).sendKeys("pounds");
        String text = driver.findElement(By.xpath("//p/input[@name='wg']")).getAttribute("value");
        Assert.assertEquals(text, "132");
        driver.close();
    }
}
