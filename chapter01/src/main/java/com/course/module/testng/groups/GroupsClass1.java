package com.course.module.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsClass1 {
    public void test01(){
        System.out.println("GroupsClass1 老师11111");
    }
    public void test02(){
        System.out.println("GroupsClass1 老师222222");
    }
}
