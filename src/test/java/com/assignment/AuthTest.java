package com.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest {

    @Test
    public void testDangKy() {
        driver.get("https://automationexercise.com/login");

        driver.findElement(By.name("name")).sendKeys("Phuc Test");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("phuc" + System.currentTimeMillis() + "@test.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        WebElement genderMale = driver.findElement(By.id("id_gender1"));
        if (!genderMale.isSelected()) genderMale.click();

        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("days")).sendKeys("10");
        driver.findElement(By.id("months")).sendKeys("June");
        driver.findElement(By.id("years")).sendKeys("2000");

        driver.findElement(By.id("first_name")).sendKeys("Phuc");
        driver.findElement(By.id("last_name")).sendKeys("Doan");
        driver.findElement(By.id("company")).sendKeys("GenZ Company");
        driver.findElement(By.id("address1")).sendKeys("123 Chill Street");
        driver.findElement(By.id("address2")).sendKeys("P.1, Q.3");

        Select country = new Select(driver.findElement(By.id("country")));
        country.selectByVisibleText("Canada");

        driver.findElement(By.id("state")).sendKeys("Ontario");
        driver.findElement(By.id("city")).sendKeys("Toronto");
        driver.findElement(By.id("zipcode")).sendKeys("12345");
        driver.findElement(By.id("mobile_number")).sendKeys("0987654321");

        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Account Created!"));
    }

    @Test
    public void testDangNhap() {
        driver.get("https://automationexercise.com/login");

        driver.findElement(By.name("email")).sendKeys("phuc@test.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();

        Assert.assertTrue(driver.getPageSource().contains("Logged in as"));
    }
}

