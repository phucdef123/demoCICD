package com.lab6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChromeTest {
    WebDriver driver;

    @Test
    public void test1(){
        System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver-win64\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[name=password]"));
        WebElement loginButton = driver.findElement(By.className("btn"));

        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        // Xác minh kết quả
        boolean isLoginSuccessful = !driver.findElements(By.xpath("//h1[contains(text(),'Logged In Successfully')]")).isEmpty();
        Assert.assertTrue(isLoginSuccessful, "Kết quả login không đúng!");

        driver.quit();
    }


}
