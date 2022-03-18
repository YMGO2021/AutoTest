package com.course.module.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "stu")
public class GroupsClass3 {
    public void test01(){
        System.out.println("GroupsClass3 学生11111");
    }
    public void test02(){
        System.out.println("GroupsClass3 学生222222");
    }
}
