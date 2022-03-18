package com.course.module.testng.parameter;

import org.testng.annotations.Test;

public class ThreadTest01 {
    @Test
    public void test01(){
        System.out.printf("线程ID %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test02(){
        System.out.printf("线程ID %s%n",Thread.currentThread().getId());
    }
    @Test
    public void test03(){
        System.out.printf("线程ID %s%n",Thread.currentThread().getId());
    }
}
