package com.lab4;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Test1 {
    @Test
    void test() {
        Assert.assertFalse(false, "false");
    }
}
