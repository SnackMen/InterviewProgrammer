package com.ws.program;

import java.util.LinkedList;

/**
 * Created by laowang on 16-9-8.
 */
public class AnimalQueue {
    private LinkedList<Dog> dogs = new LinkedList<Dog>();
    private LinkedList<Cat> cats = new LinkedList<Cat>();

    private int order = 0;

    public void enqueue(Animal a){
        /*
        order用作某种形式的时候，以便比较狗或猫插入队列的先后顺序
         */
        a.setOrder(order);
        order++;
        if(a instanceof Dog)
            dogs.addLast((Dog) a);
        else if(a instanceof Cat)
            cats.addLast((Cat) a);
    }

    public Animal dequeueAny(){
        /*
        查看狗和猫的队列首部，弹出最旧的值
        这里是判断是否有一个为空的值，如果有则直接弹出另外一个，但是如果两个都为空，
        该怎么弹
         */
        if(dogs.size() == 0){
            return dequeueCats();
        }else if(cats.size()==0){
            return dequeueDogs();
        }

        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)){
            return dequeueDogs();
        }else{
            return dequeueCats();
        }

    }
    private Dog dequeueDogs(){
        return dogs.poll();//获取并移除列表的头
    }

    private Cat dequeueCats(){
        return cats.poll();
    }

}

class Dog extends Animal{

    public Dog(String n) {
        super(n);
    }
}

class Cat extends Animal{

    public Cat(String n) {
        super(n);
    }
}
