package com.ws.program1;

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-9.
 */
public class Program {
    private int last_printed = Integer.MIN_VALUE;
    private boolean checkBST(TreeNode treeNode){
        if (treeNode==null)
            return true;
        if(!checkBST(treeNode.left))
            return false;
        if(treeNode.val<last_printed)
            return false;
        last_printed=treeNode.val;
        return checkBST(treeNode.right);

    }
}
