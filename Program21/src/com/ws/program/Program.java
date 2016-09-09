package com.ws.program;

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-9.
 */

/*
实现一个函数，检查一棵二叉树是否为平衡二叉树
 */
public class Program {
    private int index=0;
    public boolean checkBST(TreeNode root){
        int array[] = new int [root.size];
        copyBST(root,array);
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1])
                return false;
        }
        return true;
    }


    private void copyBST(TreeNode root, int[] array){
        if(root==null)
            return;
        copyBST(root.left,array);
        array[index++]=root.val;
        copyBST(root.right,array);

    }
}
