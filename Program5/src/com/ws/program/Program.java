package com.ws.program;

/**
 * 编写代码，移除未排序链表中的重复，结点
 * 进阶：
 *  如果不得使用缓冲区，改怎么解决
 */

import com.ws.linklist.LinkedListNode;

import java.util.Hashtable;

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){

    }

    private static void deleteDups(LinkedListNode node){
        Hashtable<Integer, Boolean> hashtable = new Hashtable<Integer, Boolean>();

        LinkedListNode previous = null;

        while (node!=null){
            if(hashtable.containsKey(node.val)){
                previous.next = node;
            }else{
                hashtable.put(node.val,true);
                previous = node;
            }
            node=node.next;
        }
    }
}
