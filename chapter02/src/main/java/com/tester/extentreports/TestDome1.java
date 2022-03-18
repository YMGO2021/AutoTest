package com.tester.extentreports;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestDome1 {
    @Test
    public void test01(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test02(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test03(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test04(){
        Reporter.log("自己的输出日志");
        throw new RuntimeException("自己的报错");
    }
}
