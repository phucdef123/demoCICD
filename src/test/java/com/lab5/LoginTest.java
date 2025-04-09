package com.lab5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Objects;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Java\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loginPage() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test()
    public void testLogin() {
        // Tìm các phần tử trên trang
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Nhập thông tin đăng nhập
        usernameField.sendKeys("student");
        passwordField.sendKeys("Password123");
        loginButton.click();

        // Xác minh kết quả
        boolean isLoginSuccessful = Objects.requireNonNull(driver.getTitle()).contains("Logged In Successfully");
        Assert.assertTrue(isLoginSuccessful, "Kết quả login không đúng!");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
