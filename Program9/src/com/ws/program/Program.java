package com.ws.program;

import com.ws.linklist.LinkedListNode;

/**
 * Created by laowang on 16-9-6.
 */
public class Program {
    public static void main(String []args){

    }

    LinkedListNode addLists(LinkedListNode l1,LinkedListNode l2,int carry){
        if(l1==null && l2==null && carry==0){
            return null;
        }

        LinkedListNode result = new LinkedListNode();

        /*将value以及l1和l2的val相加*/
        int value = carry;
        if(l1!=null){
            value+=l1.val;
        }
        if(l2!=null){
            value += l2.val;
        }

        result.val = value%10;/*求和结果的个位*/

        /*递归*/
        LinkedListNode more = addLists(l1==null? null:l1.next,
                l2==null? null:l2.next,
                value>=10 ? 1:0);
        result.setNext(more);//setNext()需要自己动手构造
        return result;
    }
}
