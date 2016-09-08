package com.ws.program;

import com.ws.node.TreeNode;

/*
给定一个有序的整数数组，元素各不相同且按升序排列，编写一个算法，
创建一颗高度最小的二叉查找树
 */

/**
 * Created by laowang on 16-9-8.
 */
public class Program {
    public static void main(String []args){
        int []array = new int[]{1,2,3,4,5,6,7,8,9};
        TreeNode treeNode = createMinimalBST(array);
        showNum(treeNode);
    }

    private static TreeNode createMinimalBST(int arr[], int start, int end){
        if(end<start)
            return null;
        int mid = (start + end) /2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = createMinimalBST(arr,start,mid-1);
        n.right = createMinimalBST(arr,mid+1,end);

        return n;
    }

    private static TreeNode createMinimalBST(int array[]){
        return createMinimalBST(array,0,array.length-1);
    }

    private static void showNum(TreeNode node){
        if(node!=null){
            System.out.println(node.num);
            showNum(node.left);
            showNum(node.right);
        }
    }
}
