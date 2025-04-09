package com.lab6;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

public class LoginExcelTest {
    WebDriver driver;
    Workbook workbook;
    Sheet sheet;
    int rowCount = 0;
    String filePath = "D:\\FileHocTap\\KiemThuNangCao\\Login_Test_Results.xlsx";
    File file = new File(filePath);

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.edge.driver", "D:\\Java\\edgedriver_win64\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            if (file.exists()) {
                // Nếu file đã tồn tại, mở nó
                FileInputStream fis = new FileInputStream(file);
                workbook = new XSSFWorkbook(fis);
                sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
                fis.close();
            } else {
                // Nếu file chưa tồn tại, tạo mới
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Login Test Results");

                // Tạo hàng tiêu đề
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Username");
                header.createCell(1).setCellValue("Password");
                header.createCell(2).setCellValue("Expected Result");
                header.createCell(3).setCellValue("Actual Result");
            }

            // Xác định số hàng hiện có (để không ghi đè)
            rowCount = sheet.getLastRowNum() + 1;

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Tạo file Excel mới

//        workbook = new XSSFWorkbook();
//        sheet = workbook.createSheet("Login Test Results");
//
//        // Tạo hàng tiêu đề
//        Row header = sheet.createRow(rowCount++);
//        header.createCell(0).setCellValue("Username");
//        header.createCell(1).setCellValue("Password");
//        header.createCell(2).setCellValue("Expected Result");
//        header.createCell(3).setCellValue("Actual Result");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, boolean expectedResult) {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Tìm phần tử và nhập thông tin đăng nhập
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Kiểm tra xem đăng nhập có thành công không
        boolean isLoginSuccessful = !driver.findElements(By.xpath("//h1[contains(text(),'Logged In Successfully')]")).isEmpty();
        String actualResult = isLoginSuccessful ? "Success" : "Failed";

        // Ghi kết quả vào Excel
        saveResultToExcel(username, password, expectedResult ? "Success" : "Failed", actualResult);

        // So sánh với kết quả mong đợi
        Assert.assertEquals(isLoginSuccessful, expectedResult, "Kết quả login không đúng!");
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"student", "wrongPass", false},     // Sai mật khẩu
                {"student", "Password123", true},    // Đúng
                {"wrongUser", "Password123", false}, // Sai username
                {"", "", false}                      // Bỏ trống username & password
        };
    }

    public void saveResultToExcel(String username, String password, String expected, String actual) {
        Row row = sheet.createRow(rowCount++);
        row.createCell(0).setCellValue(username);
        row.createCell(1).setCellValue(password);
        row.createCell(2).setCellValue(expected);
        row.createCell(3).setCellValue(actual);
    }

    @AfterClass
    public void teardown() {
        try {
            // Ghi dữ liệu vào file Excel

            file.getParentFile().mkdirs();
            FileOutputStream outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}

