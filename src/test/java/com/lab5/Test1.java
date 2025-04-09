package com.lab5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {
    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        try{
            String url = "https://www.google.com";
            String title_web = "Google";
            driver.get(url);
            String title = driver.getTitle();
            if (title != null && title.contentEquals(title_web)) {
                System.out.println("Test1 passed");
            }else {
                System.out.println("Test1 failed");
            }
        }finally {
            driver.quit();
        }
    }
}
