package com.couse.test;

import lombok.Data;

import java.util.Comparator;
import java.util.Objects;

@Data
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    public Person(){

    }
    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
        //return 0;//等于0是表示重复值不添加
        //return -1 ; //小于0时降序
        //return 1 ;//大于0时升序
        //int num = this.age - o.age;//升序
        int num = o.age - this.age;//降序
        int num2 = num == 0?this.name.compareTo(o.name):num;
        return num2;
    }
}
