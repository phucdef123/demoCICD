package com.lab4;

import org.testng.annotations.Test;

public class GroupTest {
    @Test(groups = "Regression")
    public void testCaseOne(){
        System.out.println("Test CaseOne");
    }
    @Test(groups = "Regression")
    public void testCaseTwo(){
        System.out.println("Test CaseTwo");
    }

    @Test(groups = "Smoke Test")
    public void testCaseThree(){
        System.out.println("Test CaseThree");
    }

    @Test(groups = "Smoke Test")
    public void testCaseFour(){
        System.out.println("Test CaseFour");
    }
}
