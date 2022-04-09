package com.couse.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test02 {
    public static String reverseWord(String s,int start,int end){
        s = "wo shi da yingxiaong";
        String[] sArray = s.split(" ");
        String test = "";
//        char[] cArray = s.toCharArray();
        int j = 0;
        for(int i = 0;i < sArray.length;i++){
            System.out.println(sArray[i]);
//            test += sArray[i];
            j += sArray[i].length();
            if(j-1 >= start && start < j-1+sArray[i+1].length()){

            }
        }

        System.out.println(test);


        return "";
    }
    public static String test02(String s,int begin,int end){
        s = "wo shi da yingxiaong";
        char[] arr = s.toCharArray();
        while (begin < end) {
            char tmp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = tmp;
            begin++;
            end--;
        }
        return arr.toString();
    }
    //冒泡排序
    public static void test03(){
        int[] intArry = {12,5,23,8,66,1};
        for(int i = 0;i < intArry.length;i++){
            int a = 0;
            for(int j = 0;j < intArry.length-1-i;j++){
                if(intArry[j] > intArry[j+1]){
                    a = intArry[j];
                    intArry[j] = intArry[j+1];
                    intArry[j+1] = a;

                }

            }

        }
        for(int i = 0;i < intArry.length;i++){
            System.out.print(intArry[i]+"    ");
        }

    }
    public static void test04(){
        String s = "62 8 90 1";
        String[] sArry = s.split(" ");

//        for(int i = 0;i < sArry.length-1;i++){
//            System.out.println(sArry[i]);
//        }
        for(int i = 0;i < sArry.length;i++){
            String a = "";
            for(int j = 0;j < sArry.length-1-i;j++){
                if(Integer.parseInt(sArry[j]) >Integer.parseInt(sArry[j+1])){
                    a = sArry[j];
                    sArry[j] = sArry[j+1];
                    sArry[j+1] = a;
                }
            }
        }
        s = "";
       for(int i = 0;i < sArry.length;i++){
//           System.out.println(sArry[i]);
//           if(i < sArry.length-1){
               sArry[i] += " ";

           s += sArry[i];
       }
        System.out.println(s);
    }
    public static void test05(){
        String s = "62 8 90 1";
        String[] sArry = s.split(" ");
        int[] intArry = new int[sArry.length];
        for(int i = 0;i < sArry.length;i++){
            intArry[i] = Integer.parseInt(sArry[i]);
        }
        Arrays.sort(intArry);
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i < intArry.length;i++){
            if(i == intArry.length-1){
                stringBuffer.append(intArry[i]);
            }else{
                stringBuffer.append(intArry[i]).append(" ");
            }

        }
        System.out.println(stringBuffer.toString());
    }
    public static void test06() throws ParseException {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        Date d = new Date();
        System.out.println(sim.format(d));
        String s = "2022-04-06 14:56:55";
        SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sim1.parse(s));

    }
    public static void test07(){
        //获取任意年份下二月份有几天
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        int date = c.get(Calendar.DATE);
        System.out.println("现在是第"+year+"的2月份总共有"+date+"天");

    }
    public static void test08(){
        //现在是2022年的第几天
        Calendar c = Calendar.getInstance();
        int day = 0;
        day += c.get(Calendar.DATE);
        for(int i = 1;i <= Calendar.MONTH+1;i++){
            c.set(Calendar.YEAR,i,1);
            c.add(Calendar.DATE,-1);
            int date = c.get(Calendar.DATE);
            System.out.println(date);
            day += date;
        }
        System.out.println("现在是2022的第"+day+"天");
    }
    public static void test09(){
        Collection<String> c = new ArrayList<String>();
        c.add("hello");
        c.add("world");
//        System.out.println(c.toString());
        Iterator<String> sI = c.iterator();
        while (sI.hasNext()){
            System.out.println(sI.next());
        }

    }
    public static void test10(){
        ArrayList<String> listS = new ArrayList<String>();
        LinkedList<String> listLink = new LinkedList<String>();
        listS.add("zhangsan");
        listLink.add("lisi");
        Iterator<String> iterator1 = listS.iterator();
        Iterator<String> iterator2 = listLink.iterator();
        listLink.addLast("haha");
        listLink.addFirst("hehe");
        listLink.removeFirst();
        System.out.println(listLink);
        System.out.println(listLink.getFirst());
    }
    public static void test11(){
        TreeSet<Person> treeSet = new TreeSet<Person>();
//        treeSet.add(1);
//        treeSet.add(2);
//        treeSet.add(2);
        Person p1 = new Person("zhangsan",30);
        Person p2 = new Person("lisi",29);
        Person p3 = new Person("wangwu",32);
        Person p4 = new Person("agan",32);
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        System.out.println(treeSet);
    }
    public static void test12(){
        TreeSet<Person> treeSet = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num = o1.getAge()-o2.getAge();
                int num2 = num == 0?o1.getName().compareTo(o2.getName()):num;
                return num2;
            }
        });
        Person p1 = new Person("zhangsan",30);
        Person p2 = new Person("lisi",29);
        Person p3 = new Person("wangwu",32);
        Person p4 = new Person("agan",32);
        Person p5 = new Person("agan",32);
        treeSet.add(p1);
        treeSet.add(p2);
        treeSet.add(p3);
        treeSet.add(p4);
        treeSet.add(p5);
        System.out.println(treeSet);
    }
    //不重复的随机数
    public static void test13(){
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        Random r = new Random();
        while (treeSet.size() < 10) {
           int a = r.nextInt(20) + 1;
            System.out.println(treeSet.size());
            treeSet.add(a);
        }
        System.out.println(treeSet);
    }
    //测试泛型类
    public static void test14(){
        Gerneric<String> ger = new Gerneric<String>();
        ger.setT("zhangsan");
        System.out.println(ger.getT());
        Gerneric<Integer> ger1 = new Gerneric<Integer>();
        ger1.setT(1);
        System.out.println(ger1.getT());

    }
    //类型通配符
    public static void test15(){
        List<?> list = new ArrayList<Object>();
        List<?> list1 = new ArrayList<Integer>();
//        List<? extends Number> list3 = new ArrayList<Object>();
        List<? extends Number> list4 = new ArrayList<Integer>();
        List<? super Number> list5 = new ArrayList<Object>();
    }
    //可变参数
    public static int test16(int...a){
        int sum = 0;
        for(int i:a){
            sum += i;
        }
        System.out.println(sum);
        return sum;
    }
    //可变参数
    public static void test17(int...a){
        List<String> list = Arrays.asList("1","2","3");


    }
    public static void main(String[] args) throws ParseException {
//        reverseWord("ss",0,2);
//        test02("ss",0,2);
//          Integer i = 9;
//          String s = (String)i;
         test16(1,2,3);
    }
}

