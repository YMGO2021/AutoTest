package com.course.module.testng.parameter;

import org.testng.annotations.Test;

public class TimeOut {
    @Test(timeOut = 3000)
    //执行成功
    public void tets01() throws InterruptedException {
        Thread.sleep(2000);
    }
    @Test(timeOut = 2000)
    //执行失败
    public void tets02() throws InterruptedException {
        Thread.sleep(3000);
    }
}
