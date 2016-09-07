package com.ws.queue;

import java.util.Stack;

/**
 * Created by laowang on 16-9-7.
 */
class MyQueue<T> {
    private Stack<T> stackNewest,stackOldest;

    public MyQueue(){
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }

    public int size(){
        return stackNewest.size()+stackOldest.size();
    }

    public void add(T value){
        /*
        压入stackNewest,最新元素始终位于它的顶端
         */
        stackNewest.push(value);
    }

    /*
    将元素从stackNewest移至stackOldest,这么做通常是为例要在stackOldest上执行操作
     */
    private void shiftStacks(){
        if(stackOldest.isEmpty()){
            while(!stackNewest.isEmpty()){//细节
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek(){
        shiftStacks();//确保stackOldest含有当前元素
        return stackOldest.peek();
    }

    public T remove(){
        shiftStacks();//确保stackOldest含有当前元素
        return stackOldest.pop();//弹出最旧的元素
    }
}
