package com.course.test;
class Animal{
    public void move(){
        System.out.println("动物可以移动");
    }
    public static void show(Animal a){
        if(a instanceof Dog){
           Dog aa = (Dog)a;
           aa.move();
        }else if(a instanceof Cat){
            Cat cc = (Cat)a;
            cc.move();
        }
    }


    public static void main(String args[]){
//        Animal a = new Animal(); // Animal 对象
//        Animal b = new Dog(); // Dog 对象
//        Dog c= new Dog(); // Dog 对象
//        a.move();// 执行 Animal 类的方法
//        b.move();//执行 Dog 类的方法
//        c.bark();
        show(new Dog());
        show(new Cat());
    }
}
