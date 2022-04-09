package com.couse.test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test03 {
    public static void test01(){
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","zhangsan");
        map.put("2","lisi");
        System.out.println(map.get("1"));
        Set<String> set = map.keySet();
        Collection<String> c = map.values();
        Set<Map.Entry<String,String>> set1 = map.entrySet();
        for(Map.Entry m:set1){
            m.getKey();
            m.getValue();

        }
    }
    public static void test02(){
     HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("zhangsann");
        list.add("lisi");
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("zhangsann");
        list1.add("lisi");
        map.put("1",list);
        map.put("2",list1);
        Set<String> set = map.keySet();
        for(String s:set){
            ArrayList<String> list2 = map.get(s);
            for(String s1:list2){
                System.out.println(s1);

            }
        }
    }
    //统计字符串里每个字符出现的次数
    public static void test03(){
        String s = "aaaabbk";
        char[] c = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char cc:c){
            map.put(cc,0);
        }
        Set<Character> set = map.keySet();
        for(Character ss:set){
//            System.out.println(ss);
            int a = 0;
            for(char cc:c){
               if(ss == cc){
                   ++a;
               }
            }
            map.put(ss,a);
        }
        for(Character ss:set){
            System.out.print(ss+"   ");
            System.out.println(map.get(ss));
        }
    }
    //统计字符串里每个字符出现的次数
    public static void test04(){
        String s = "aaaabbk";
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i < s.length();i++ ){
            char key = s.charAt(i);
            Integer value = map.get(key);
            if(value == null){
                map.put(key,1);
            }else{
                ++value;
                map.put(key,value);
            }
        }
        Set<Character> set = map.keySet();
        for(Character ss:set){
            System.out.print(ss+"   ");
            System.out.println(map.get(ss));
        }
    }
    //collection常用方法
    public static void test05(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("1");
        list.add("3");
        list.add("2");
//        Collections.sort(list);
//        Collections.reverse(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
    //模拟斗地主
    public static void test06(){
    ArrayList<String> pai = new ArrayList<String>();
    String[] huase = {"方块","红心","黑桃","花子"};
    String[] shuzi = {"2","3","4","5","6","7","8","9","10","J"};
    for(int i = 0;i < huase.length;i++){
        for(int j = 0;j < shuzi.length;j++){
            String a = huase[i]+shuzi[j];
            pai.add(a);
        }
    }
    Collections.shuffle(pai);
        ArrayList<String> pai1 = new ArrayList<String>();
        ArrayList<String> pai2 = new ArrayList<String>();
        ArrayList<String> pai3 = new ArrayList<String>();
        ArrayList<String> pai4 = new ArrayList<String>();
        for(int i = 0;i < pai.size();i++){
            if(i >= pai.size()-3){
                pai4.add(pai.get(i));
            }else if(i%3 == 0){//有几个人就对几取余
                pai1.add(pai.get(i));
            }else if(i%3 == 1){
                pai2.add(pai.get(i));
            }else if(i%3 == 2){
                pai3.add(pai.get(i));
            }
        }
        test07(pai1);
        test07(pai2);
        test07(pai3);
        test07(pai4);
    }
    //遍历
    public static void test07(ArrayList<String> pai){
        for(String s:pai){
            System.out.println(s);
        }

    }
    public static void test08(){
        int[] i = {1,2,4,5,6};
        int[] i1 = {1,2,4,5,6};
        byte[] b = {8,44,5};
        int c = 9;
        Integer.valueOf(c);
        Integer cc = 10;
        int vv = cc.intValue();
        List<int[]> list = Arrays.asList(i);
        ArrayList<int[]> list1 = (ArrayList<int[]>)list;
//        Arrays.fill(i,6);
        int[] a = Arrays.copyOf(i,3);
//        System.out.println(Arrays.equals(i,i1));
//        System.out.println(Arrays.toString(i));
        for(int ii:i){
            System.out.println(ii);
        }
        for(int aa:a){
            System.out.println(aa);
        }
//        for(int ii = 0;ii < i.length;ii++){
//            System.out.println(i[ii]);
//        }

    }
    public static void test09() throws ParseException {
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        sim.format(date);
        String date1 = "2022-04-08 20:45:30";
        sim.parse(date1);
        System.out.println(sim.format(sim.parse(date1)));

    }
    public static void test10(){
        Calendar c = Calendar.getInstance();
        c.get(Calendar.YEAR);
        System.out.println(c.get(Calendar.YEAR));
        c.add(Calendar.YEAR,1);
        System.out.println(c.get(Calendar.YEAR));
        c.add(Calendar.DATE,-1);
        System.out.println(c.get(Calendar.DATE));
        c.set(2019,8,12);
        System.out.println(c.get(Calendar.YEAR));
    }
    public static void test11(){
          Collection<String> c = new ArrayList<String>();
          c.add("zhangsan");
          c.add("lisi");
          c.add("wangwu");
          Iterator<String> i = c.iterator();
          while (i.hasNext()){
              System.out.println(i.next());
          }
        ArrayList<String> list = new ArrayList<String>();
        ListIterator<String> list1 = list.listIterator();
       LinkedHashSet<String> link = new LinkedHashSet<String>();
        for(String s:link){
            System.out.println(s);
        }
        link.add("zhangsan");
        link.add("lisi");
        Iterator<String> it = link.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
        TreeSet<Integer> treeSet = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
    public static void test12(){
      HashMap<String,String> map = new HashMap<String,String>();
      map.put("zhangsan","2");
      Set<String> set = map.keySet();
      for(String s:set){
          map.get(s);
      }
      Collection<String> c =map.values();
      for(String s:c){
          System.out.println(s);
      }
      Set<Map.Entry<String, String>> entries = map.entrySet();
      for(Map.Entry m:entries){
          m.getKey();
          m.getValue();
      }

    }
    public static void test13() throws IOException {
        File file1 = new File("D:\\test\\test.txt");
//        file1.createNewFile();
        File file2 = new File("D:\\test\\test1");
//        file2.mkdir();
        File file3 = new File("D:\\test\\A\\a");
//          file3.mkdirs();
        File file4 = new File(file3,"b");
//        file4.mkdir();
        File file5 = new File("D:\\test\\B\\b","bb");
        file5.mkdirs();
    }
    public static void test14() throws IOException {
//      File file = new File("D:\\test");
//        System.out.println(file.isDirectory());
//        File[] files = file.listFiles();
//        for(File file1:files){
//            if(file1.isFile()){
//                System.out.println(file1.getName());
//            }
//        }
        File file2 = new File("test");
        //System.out.println(file2.mkdirs());
        File file3 = new File("test\\a.txt");
        //System.out.println(file3.createNewFile());
        System.out.println(file2.delete());
//        file2.delete()
    }
    //递归
    public static int test15(int n) {
        if(n == 1 || n == 2){
            return 1;
        }else {
            return test15(n-1)+test15(n-2);
        }

    }
    //递归
    public static int test16(int n) {
        if(n == 1){
            return 1;
        }else{
            return n*test16(n-1);
        }
    }
    //递归
    public static void dgFile(File file) {
//        File file = new File("D:\\test");
        File[] f =file.listFiles();
        if(f != null) {
            for (File ff : f) {
                if (ff.isDirectory()) {
                    System.out.println(ff.getAbsolutePath());
                    dgFile(ff);
                } else {
                    System.out.println(ff.getAbsolutePath());
                }
            }
        }
    }
    //字节输出流
    public static void test17() throws IOException {
        File file = new File("test02");
        file.mkdir();
        File file2 = new File("test02\\test.txt");
        file2.createNewFile();
        FileOutputStream file1 = new FileOutputStream(file2);
        byte[] bytes = "abgxdd".getBytes(StandardCharsets.UTF_8);
        file1.write(bytes);
        file1.close();
    }
    //字节输出流
    public static void test18()  {
//        File file = new File("test02");
//        file.mkdir();
//        File file2 = new File("test02\\test.txt");
//        file2.createNewFile();
        FileOutputStream file1 = null;
        try {
            file1 = new FileOutputStream("test02\\test1.txt", true);
            file1.write("hshshsh".getBytes(StandardCharsets.UTF_8));
            file1.write("\r\n".getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(file1 != null){
                try{
                    file1.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
    //字节输入流
    public static void test19() throws IOException {
        FileInputStream f = new FileInputStream("test02\\test.txt");
        int b ;
        while ((b = f.read()) != -1){
            System.out.print((char)b);
        }
    }
    //复制文件
    public static void test20() throws IOException {
       FileInputStream f1 = new FileInputStream("test02\\test.txt");
       FileOutputStream f2 = new FileOutputStream("test02\\test1.txt");
       int b;
       while((b = f1.read()) != -1){
           f2.write(b);
       }
       f1.close();
       f2.close();
    }
    //复制文件
    public static void test21() throws IOException {
        FileInputStream f1 = new FileInputStream("test02\\test.txt");
        FileOutputStream f2 = new FileOutputStream("test02\\test1.txt");
        byte[] b = new byte[1024];
        int leng;
        while((leng =f1.read(b)) != -1){
            f2.write(b,0,leng);
        }
        f1.close();
        f2.close();
    }
    //字节缓冲流
    public static void test22() throws IOException {
//      BufferedInputStream bInputStream = new BufferedInputStream(new FileInputStream("test02\\test.txt"));
//        int a;
//        while((a = bInputStream.read()) != -1){
//            System.out.println((char)a);
//        }
//        byte[] b = new byte[1024];
//        int leng;
//        while((leng = bInputStream.read(b)) != -1){
//            System.out.println(new String(b,0,leng));
//        }
        BufferedOutputStream bOutputStream = new BufferedOutputStream(new FileOutputStream("test02\\test.txt"));
        bOutputStream.write("88888".getBytes());
//        bInputStream.close();
        bOutputStream.close();
    }
    public static void main(String[] args) throws Exception {
//        test14();
//        int n = test15(20);
//        System.out.println(n);
//        System.out.println(test16(4));
//        File file = new File("D:\\test");
//        dgFile(file);
          test22();

    }
}
