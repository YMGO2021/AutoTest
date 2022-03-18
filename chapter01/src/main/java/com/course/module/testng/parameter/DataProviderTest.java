package com.course.module.testng.parameter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    //只要参数匹配上就执行，不做差异化处理
    @Test(dataProvider = "data1")
    public void test01(String name,int age){
        System.out.println("name="+name+"；  age="+age);
    }
    @DataProvider(name="data1")
    public Object[][] data01(){
        Object[][] o = new Object[][]{{"zhangsan",10},{"lisi",20}};
        return o;
    }
    //参数匹配上后，通过传递Method参数，进行方法参数的差异化
    @Test(dataProvider = "data2")
    public void test02(String name,int age){
        System.out.println("name="+name+"；  age="+age);
    }
    @Test(dataProvider = "data2")
    public void test03(String name,int age){
        System.out.println("name="+name+"；  age="+age);
    }
    @DataProvider(name="data2")
    public Object[][] data02(Method method){
        Object[][] o = null;
        if(method.getName().equals("test02")){
            o = new Object[][]{
                    {"zhangsan",10},{"lisi",20}
            };
        }
        else if(method.getName().equals("test03")){
            o = new Object[][]{
                    {"wangwu",30},{"zhaoliu",60}
            };
        }
        return  o;
    }
}
