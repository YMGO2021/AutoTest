package com.course.module.testng.groups;

import org.testng.annotations.Test;

public class DependMethod {
    @Test
    public void test01(){
        System.out.println(11111);
    }
    @Test
    public void test02(){
        System.out.println(22222);
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = {"test01","test02"})
    public void test03(){
        System.out.println(333333);
    }
}
