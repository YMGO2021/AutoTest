package com.couse.test;

public class Teacher extends Person {
    public Teacher(){
    }
    public Teacher(String name,int age){
        this.setName(name);
        this.setAge(age);
//        super(name,age);
    }
    public void tesch(){
        System.out.println("name"+this.getName()+"age"+this.getAge());
        System.out.println("教书育人！！！");
    }
}
