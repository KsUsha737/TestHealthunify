package com.healthunify.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestOpenStartPage {
    @Test
    public void testOpenPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");
        String text = driver.findElement(By.xpath("//div/header/h1[@class='entry-title']")).getText();
        Assert.assertEquals(text, "BMI Calculator");
        driver.get("https://healthunify.com/bmicalculator/");
        driver.close();
    }


}
