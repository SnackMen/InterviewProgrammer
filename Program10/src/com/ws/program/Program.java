package com.ws.program;

/*
给定一个有环链表，实现一个算法返回的开头结点
 */

import com.ws.linklist.LinkedListNode;

/**
 * Created by laowang on 16-9-7.
 */
public class Program {

    public static void main(String []args){

    }

    LinkedListNode FindBeginning(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        /*
        找出碰撞处，将处于连表中LOOP_SIZE-k步位置
         */
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
            if(slow == fast){//碰撞
                break;
            }

            /*
            错误检查，没有碰撞处，也即没有环路
             */
            if(fast.next == null){
                return null;
            }

            slow = head;
            while(slow != fast){
                slow = slow.next;
                fast = fast.next;
            }



        }
        /*
        两者均指向环路起始处
         */
        return fast;
    }

}
