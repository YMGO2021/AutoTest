package com.course.module.testng.parameter;

import org.testng.annotations.Test;

public class ThreadTest {
    @Test(invocationCount = 10,threadPoolSize = 2)
    public void test01(){
        System.out.println(1);
        System.out.printf("线程ID %s%n",Thread.currentThread().getId());
    }
}
