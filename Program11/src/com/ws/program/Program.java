package com.ws.program;

/*
描述如何使用一个数组来实现三个栈
 */

/**
 * Created by laowang on 16-9-7.
 */

//方法一 固定分割大小
public class Program {
    private int stackSize = 100;
    private int []buffer = new int [stackSize/3];
    private int []stackPointer = {-1,-1,-1};//用于追踪栈顶元素的指针
    public static void main(String []args){

    }

    public void push(int stackNum,int value) throws Exception{
        //检查有无空闲空间
        if(stackPointer[stackNum]+1 >= stackSize){//最后一个元素
            throw new Exception("Out of space");
        }

        //栈指针自增，然后更新栈顶元素的值
        stackPointer[stackNum] ++;
        buffer[absTopStack(stackNum)] = value;
    }

    public int pop(int stackNum) throws Exception{
        if(stackPointer[stackNum] == -1){
            throw new Exception("Trying to pop a  empty stack.");
        }
        int value = buffer[absTopStack(stackNum)];//获取栈顶元素的值
        buffer[absTopStack(stackNum)] = 0;
        stackPointer[stackNum]--;
        return value;
    }

    public int peek(int stackNum){
        int index = absTopStack(stackNum);
        return buffer[index];
    }

    boolean isEmpty(int stackNum){
        return stackPointer[stackNum] == -1;
    }

    //返回stackNum 栈顶元素的索引，绝对量
    private int absTopStack(int stackNum) {
        return stackNum*stackSize + stackPointer[stackNum];
    }
}
