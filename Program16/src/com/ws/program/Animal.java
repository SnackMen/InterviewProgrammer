package com.ws.program;

/*
有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则，在收养该收容所的
动物时，收养人只能收养所有动物中“最老（根据收容所的时间长短）”的动物，或者可以
挑选猫或狗（同时必须收养此类动物中的”最老“的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构
实现各种操作方法，比如enqueue,dequeueAny,dequeueDog和dequeueCat等。允许使用java内置的LinkedList数据结构
 */

/**
 * Created by laowang on 16-9-8.
 */
abstract class Animal {
    private int getOrder() {
        return order;
    }

    void setOrder(int order) {
        this.order = order;
    }

    private int order;
    private String name;
    Animal(String n){
        name = n;
    }

    boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }


}
