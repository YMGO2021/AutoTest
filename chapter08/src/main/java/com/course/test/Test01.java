package com.course.test;

import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.http.entity.StringEntity;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Test01 {

    public void test01() throws Exception {
        SqlSession s1 = DatabaseUtil.getSession();
        SqlSession s2 = DatabaseUtil.getSession();
//        DatabaseUtil da = new DatabaseUtil();
//        DatabaseUtil da1 = new DatabaseUtil();
//        System.out.println(s1 == s2);
//        System.out.println(da);
//        System.out.println(da1);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(222);
        list.add(3);
        System.out.println(list.get(1));
        String[] s = {"tets","ggg"};
        String[] ss = new String[2];
        ss[0] = "887";
        ss[1] = "988";
        LinkedList<String>  link = new LinkedList<String>();
        link.add("45554");
        link.add("66555");
        link.add("88777");
        link.add("99088");
        link.remove(3);
//        System.out.println(link.get(2));
//        link.add("9999");
//        System.out.println(link.get(3));
        for(int i = 0;i < link.size();i++){
            System.out.println(link.get(i));
        }
        AddUserCase addUserCase = new AddUserCase();
        addUserCase.setAge("18");
        addUserCase.setUserName("zhangsan");
        addUserCase.setSex("nan");
        System.out.println(addUserCase.toString());
        JSONObject param = new JSONObject();
        param.put("userName",addUserCase.getUserName());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        System.out.println(param.toString());
        StringEntity entity = new StringEntity(param.toString());
        System.out.println(entity);
        int i =128;
        byte b = (byte)i;
        System.out.println(b);
    }
    public static void test02(){
        char c = 'C';
        switch(c){
            case 'A' :
                System.out.println(123);
            case 'C':
                System.out.println(345);
                break;
            default:
                System.out.println(567);

        }
    }
    public static void test03(){
        Scanner scanner = new Scanner(System.in);
        String s = null;
        if(scanner.hasNext()){
            s = scanner.next();
            if(s.equals("A")){
                System.out.println("优秀");
            }else if(s.equals("B")){
                System.out.println("良好");
            }else{
                System.out.println("及格");
            }
        }

    }
    public static void test04(){
         Integer a = -9;
         Integer b = 1;
         Math.max(a,b);
         String s= "1";
         Character  c = 't';
        int aa = 8;
        Character.isLetter('A');
         String ss = c.toString();
         char[] cc = ss.toCharArray();
        System.out.println(Math.abs(a));
         a.compareTo(b);
        System.out.println(a.compareTo(b));
        System.out.println(Math.random());
        System.out.println("\"菜鸟\"课程！");
        System.out.println("菜鸟\n课程！");
        StringBuffer sBuffer = new StringBuffer(10);
        sBuffer.append("哈哈");
        sBuffer.insert(2,"!!1");
        System.out.println(sBuffer);
        String sss = "hdggddssdddd";
        String test = sss.substring(0,4);
        System.out.println(test);
        System.out.println(sss);
    }
    public static void test05() throws Exception{
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("448hhdjdjd33hhh");
        LinkedList<Integer> intList = new LinkedList();
        LinkedList<String > stringList = new LinkedList();
        for(int i = 0;i < stringBuilder.length();i++){
            if(Character.isDigit(stringBuilder.charAt(i))){
                intList.add(Integer.valueOf(String.valueOf(stringBuilder.charAt(i))));
            }else{
//                System.out.println(stringBuilder.charAt(i));
                stringList.add(String.valueOf(stringBuilder.charAt(i)));
            }
        }
        Integer[] intArray = new Integer[intList.size()];
        intList.toArray(intArray);
//        String[] stringArray = (String[]) stringList.toArray();
        int c = 0;
        for(int i = 0;i < intArray.length;i++){
            for(int j = i+1; j < intArray.length-1;j++){
                if(intArray[i]>intArray[j]){
                    c = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = c;
                }
            }

        }
        for(int i = 0;i < intArray.length;i++){
            System.out.println(intArray[i]);
        }

    }
    public static void test06(){
//        String[] s = {"a","b","c"};
//        for(String a : s){
//            System.out.println(a);
//        }
        BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));


    }
     public static boolean test07(){
           String testS = "qweuyyt6tuewq";
           int t = 1;
           boolean result = true;
           char[] charArray = testS.toCharArray();
           for(int i = 0;i < charArray.length/2;i++){
               if(charArray[i] == charArray[charArray.length-1-i]){
                   System.out.println("22222222222222");
                   result = true;
               }
               else{
                   System.out.println("333333333333333333");
                   result = false;
                   break;
               }
           }
         System.out.println(result);
           return result;
     }

    public static void main(String[] args) throws Exception {
        test07();
    }
}

