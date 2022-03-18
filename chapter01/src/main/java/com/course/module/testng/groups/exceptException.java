package com.course.module.testng.groups;

import org.testng.annotations.Test;

public class exceptException {
    @Test(expectedExceptions = RuntimeException.class)
    public void test01() throws Exception {
        //要写在抛出异常之前，否则不会被执行
        System.out.println("1111111111");
        throw new RuntimeException();
    }
}
