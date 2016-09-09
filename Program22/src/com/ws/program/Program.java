package com.ws.program;

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-9.
 */
public class Program {
    public boolean checkBST(TreeNode root){
        return checkBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean checkBST(TreeNode root, int min, int max) {
        return root == null || !(root.val < min || root.val > max) && !(!checkBST(root.left, min, root.val) || checkBST(root.right, root.val, max));
    }
}
