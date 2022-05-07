package com.healthunify.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIndexCategory {

    @Test
    public void testIndexCategory() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://healthunify.com/bmicalculator/");

        WebElement weightField = driver.findElement(By.xpath("//p/input[@name='wg']"));
        weightField.sendKeys("63");
        driver.findElement(By.xpath("//p/select[@name='opt1']")).click();
        driver.findElement(By.xpath("//p/select[@name='opt1']/option[@value='kilograms']")).click();
        driver.findElement(By.xpath("//p/input[@class='innerc resform']")).sendKeys("160");
        WebElement calculateButton = driver.findElement(By.xpath("//p/input[@name='cc']"));
        calculateButton.click();
        WebElement calculateResult = driver.findElement(By.xpath("//td/input[@class='content']"));
        String result = calculateResult.getAttribute("value");
        Assert.assertEquals(result, "Your category is Normal");

        weightField.clear();
        weightField.sendKeys("64");
        calculateButton.click();
        result = calculateResult.getAttribute("value");
        Assert.assertEquals(result, "Your category is Normal");

        weightField.clear();
        weightField.sendKeys("65");
        calculateButton.click();
        result = calculateResult.getAttribute("value");
        Assert.assertEquals(result, "Your category is Overweight");

        weightField.clear();
        weightField.sendKeys("ghj");
        calculateButton.click();
        String value = driver.findElement(By.xpath("//td/input[@class='resform'][@name='si']")).getAttribute("value");
        Assert.assertEquals(value,"NaN");

        driver.close();
    }
}

