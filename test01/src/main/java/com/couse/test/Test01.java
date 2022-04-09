package com.couse.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Test01 {
    public static void test01(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = (a>b)?a:b;
        int max = (d>c)?d:c;
        System.out.println(max);
    }
   public static void test02(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a%2 == 0){
            System.out.println("我是偶数");
        }else{
            System.out.println("我是奇数");
        }
   }
   public static void test03(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        switch (a) {
            case 2:
            case 3:
            case 12:
                System.out.println("冬天");
                break;
            case 4:
            case 5:
            case 6:
                System.out.println("春天");
                break;
            default:
                System.out.println("输入有误");

        }
   }
    public static void test04(){
        int sum = 0;
        for(int i = 1;i <=5;i++){
            sum +=i;
        }
        System.out.println(sum);
    }
    public static void test05(){
        int sum = 0;
        for(int i = 1;i <=100;i++){
            if(i%2 == 0){
                sum += i;
            }
        }
        System.out.println(sum);
    }
    public static void test06(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String s = Integer.toString(a);
        String[] sArray = s.split("");
        int sum = 0;
        for(int i = 0;i < sArray.length;i++){
            int d =Integer.parseInt(sArray[i]);
            sum += d*d*d;
        }
        if(a == sum){
            System.out.println("我是水仙花！！！");
        }else{
            System.out.println("我不是水仙花！！！");
        }
    }
    public static void test07(){
        int total = 0;
        for(int i = 100;i <= 999;i++){
           int ge = i%10;
           int shi = i/10%10;
           int bai = i/100;
           if(ge*ge*ge+shi*shi*shi+bai*bai*bai == i){
               System.out.println(i+"我是水仙花！！");
               total++;
           }
        }
        System.out.println(total);
    }
    public static void test08(){
        double paper = 0.1;
        int count = 0;
        while (paper <= 8844430.00){
            paper *= 2;
            System.out.println(paper);
            count++;
        }
        System.out.println(count);
    }
    public static void test09(){
        Random r = new Random();
        int a = r.nextInt(100);
        System.out.println(a);
    }
    public static void test10() throws Exception {
        Random r = new Random();
        int t= r.nextInt(100)+1;
        System.out.println(t);
        while(true){
            Scanner sc = new Scanner(System.in);
            int d = sc.nextInt();
            if(t > d){
                System.out.println("你输入的值小了，请重新输入");
            }else if(t < d){
                System.out.println("你输入的值大了，请重新输入");
            }else{
                System.out.println("恭喜猜中！");
                break;
            }
        }

    }
     public static void test11(int[] a){
        a = new int[3];
        a[0] = 8;
         System.out.println(a[0]);
     }
     public static void test12(){
        int[] arr ={12,34,78,88};
        int a = 0;
        for(int i = 0;i < arr.length/2;i++){
            a = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = a;
        }
        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }
     }
    public static void test13(){
        int[] arr ={12,34,78,88};
        int a = 0;
        for(int start = 0,end = arr.length-1;start <= end;start++,end--){
            a = arr[start];
            arr[start] = arr[end];
            arr[end] = a;
        }
        for(int i = 0;i < arr.length;i++){
            System.out.print(arr[i]+"   ");
        }
    }
    public static void test14(){
        Random r =new Random();
        int[] arr = new int[6];
        for(int i = 0;i < 6;i++){
            arr[i] = r.nextInt(101);
            System.out.print(arr[i]+"  ");
        }
        System.out.println("---------------------");
        int max = arr[0];
        int min = arr[0];
        for(int j = 0;j < arr.length-1;j++){
        if(max < arr[j+1]){
            max = arr[j+1];
        }
        }
        for(int j = 0;j < arr.length-2;j++){
            if(min > arr[j+1]){
                min = arr[j+1];
            }
        }
            System.out.print(max+"  ");
            System.out.print(min+"  ");
    }
    public static void test15(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0;i < s.length();i++){
            System.out.println(s.charAt(i));
        }

    }
    public static void test16(){
      Scanner sc = new Scanner(System.in);
      String s = sc.nextLine();
      int a = 0;
      int b = 0;
      int c = 0;
      for(int i = 0;i < s.length();i++){
          if(s.charAt(i) >='A' && s.charAt(i) <= 'Z'){
                a++;
          }else if(s.charAt(i) >='a' && s.charAt(i) <= 'z'){
                b++;
          }else if(s.charAt(i) >='0' && s.charAt(i) <= '9'){
               c++;
          }
      }
        System.out.println(a+"    "+b+"    "+c);


    }
    //字符串反转
    public static void test17(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sNew = "";
        System.out.println(s.length()-1);
        for(int i = s.length()-1; i >= 0;i--){
            sNew += s.charAt(i);
        }
        System.out.println(sNew);

    }
    //集合练习
    public static void test18(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(Integer i: list){
            System.out.println(i);

        }
    }
    public static void main(String[] args) throws Exception {
        //test01();
//        test02();
//        test03();
//        test04();
//        test05();
        test18();
//        int[] a ={1,2,3};
//        System.out.println(a[0]);
//        test11(a);
//        System.out.println(a[0]);
//        StringBuffer sb = new StringBuffer();
//        sb.append("hsh").append("hhh");
//        sb.reverse();
//        System.out.println(sb);

    }
}
