package com.course.module.testng;
import org.testng.annotations.*;

public class BasicAnnotation {
    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase01(){
        //sout +回车，快捷打印代码
        System.out.println("这是测试用例01");
    }
    @Test
    public void testCase02(){
        System.out.println("这是测试用例02");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("方法之前");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("方法之后");
    }
    @BeforeClass
    public  void beforeClass(){
        System.out.println("类之前");
    }
    @AfterClass
    public  void afterClass(){
        System.out.println("类之后");
    }
    @BeforeSuite
    public  void beforeSuite(){
        System.out.println("套件之前");
    }
    @AfterSuite
    public  void afterSuite(){
        System.out.println("套件之后");
    }
}
