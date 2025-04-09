package com.lab6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EdgeTest {
    WebDriver driver;

    @Test
    public void loginTest() {
        System.setProperty("webdriver.edge.driver", "D:\\Java\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebElement usernameField = driver.findElement(By.cssSelector("input[id=username]"));
        WebElement passwordField = driver.findElement(By.cssSelector("input[id=password]"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[id=submit]"));

        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        // Xác minh kết quả
        String title = driver.getTitle();
        boolean expectedTitle = false;
        if (title != null) {
            expectedTitle = title.contains("Logged In Successfully");
        }
        Assert.assertTrue(expectedTitle, "Kết quả không đúng");

        driver.quit();
    }
}
