package com.couse.test;

import java.io.IOException;
import java.util.Arrays;

public class Test04 {
    //测试字符编码
    public static void test01(){
      String s = "中国";
      System.out.println(Arrays.toString(s.getBytes()));
      System.out.println(new String(s.getBytes()));
    }
    public static void main(String[] args) {
        test01();
    }
}
