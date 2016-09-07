package com.ws.program;

import java.util.Stack;

/**
 * Created by laowang on 16-9-7.
 */
public class Program {
    public static void main(String []args){
        int n=3;
        Tower[] towers = new Tower[n];
        for(int i=0;i<3;i++){
            towers[i] = new Tower(i);
        }

        //第一塔里面装有数据
        for(int i=n-1;i>=0;i--){
            towers[0].add(i);
        }
        //从第一个塔移动盘子到其他两个塔
        towers[0].moveDisks(n,towers[2],towers[1]);
    }
}

class Tower{
    private Stack<Integer> disks;
    private int index;
    Tower(int i){
        disks = new Stack<Integer>();
        index = i;
    }

    private int index(){
        return index;
    }

    //往塔里面按顺序加盘子
    void add(int d){
        if(!disks.isEmpty() && disks.peek() <=d ){
            System.out.println("Error placing disk "+d);
        }else{
            disks.push(d);
        }
    }

    private void moveTopTo(Tower t){
        int top = disks.pop();
        t.add(top);
        System.out.println("Move disk"+ top +" from " + index() + " to " + t.index());
    }

    void moveDisks(int n, Tower destination, Tower buffer){
        if(n >0){
            moveDisks(n-1,buffer,destination);
            moveTopTo(destination);
            buffer.moveDisks(n-1,destination,this);
        }
    }
}
