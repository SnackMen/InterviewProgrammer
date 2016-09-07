package com.ws.stack;

import java.util.Stack;

/**
 * Created by laowang on 16-9-7.
 */
public class StackWithMin extends Stack<NodeWithMin> {
    public void push(int value){
        int newMin = Math.min(value,min());
        super.push(new NodeWithMin(value,newMin));
    }

    private int min(){
        if(this.isEmpty()){
            return Integer.MAX_VALUE;//错误值
        }else{
            return peek().min;
        }
    }
}
