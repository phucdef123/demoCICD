package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTableTest extends BaseTest {

    @Test
    public void testCreateRecord() {
        driver.get("https://demoqa.com/webtables");

        WebElement addBtn = driver.findElement(By.id("addNewRecordButton"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addBtn);

        driver.findElement(By.id("firstName")).sendKeys("Phuc");
        driver.findElement(By.id("lastName")).sendKeys("Doan");
        driver.findElement(By.id("userEmail")).sendKeys("phuc@test.com");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("salary")).sendKeys("1000");
        driver.findElement(By.id("department")).sendKeys("QA");
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.getPageSource().contains("Phuc"));
    }

    @Test
    public void testEditRecord() {
        driver.get("https://demoqa.com/webtables");

        WebElement editBtn = driver.findElement(By.id("edit-record-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);

        WebElement dept = driver.findElement(By.id("department"));
        dept.clear();
        dept.sendKeys("Automation");
        driver.findElement(By.id("submit")).click();

        Assert.assertTrue(driver.getPageSource().contains("Automation"));
    }

    @Test
    public void testDeleteRecord() {
        driver.get("https://demoqa.com/webtables");

        WebElement deleteBtn = driver.findElement(By.id("delete-record-1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);

        Assert.assertFalse(driver.getPageSource().contains("Insurance"));
    }
}

