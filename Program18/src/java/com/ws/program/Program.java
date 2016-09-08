package com.ws.program;

/*
方法一 效率不高，会反复访问每个结点的整个子树，事件复杂度 O(N logg N)
 */
import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-8.
 */
public class Program {
    private static int getHeight(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }

    private static boolean isBalanced(TreeNode root) {//判断是否是平衡二叉树
        if (root == null)//终止条件
            return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        return Math.abs(heightDiff) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
