package com.course.module.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsMethod {
    @Test(groups = "serv")
    public void test01(){
        System.out.println("11111111111");
    }
    @Test(groups = "client")
    public void test02(){
        System.out.println("2222222");
    }
//    @BeforeGroups("serv")
//    public void bef(){
//        System.out.println("aaaaaaaaaaaaaaaaaa");
//    }
//    @AfterGroups("client")
//    public void after(){
//        System.out.println("bbbbbbbbbbbbbbbbb");
//    }
//    @AfterGroups("serv")
//    public void after1(){
//        System.out.println("cccccccccccc");
//    }
}
