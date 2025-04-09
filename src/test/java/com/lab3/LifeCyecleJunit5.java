package com.lab3;

import org.junit.jupiter.api.*;

public class LifeCyecleJunit5 {
    // Before All chạy đầu
    @BeforeAll
    static void initALL(){
        System.out.print("1\t");
        System.out.println("Before All - Run first");
    }

    // BeforeEach chạy trước mỗi @Test.
    @BeforeEach
    void init(){
        System.out.print("2\t");
        System.out.println("Before Each - Run before each test methods");
    }

    // @Test có tên là "First Test"
    @DisplayName("First Test")
    @Test
    void testMethod1(){
        System.out.print("3\t");
        System.out.println("Test Method 1");
    }

    // Test bị vô hiệu hóa
    @Test
    @Disabled
    void testMethod2(){
        System.out.println("4");
        System.out.println("Test Method 2");
    }

    // Test bình thường
    @Test
    void testMethod3(){
        System.out.print("5\t");
        System.out.println("Test Method 3");
    }

    // AfterEach chạy sau mỗi @Test.
    @AfterEach
    void tearDown(){
        System.out.print("6\t");
        System.out.println("After Each - Run after each test methods");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.print("7\t");
        System.out.println("After All - Run after all test methods");
    }
}
