package com.ws.program;

/*
你有两棵非常大的二叉树，T1,有几百万个结点；T2,有几百个结点，设计一个算法，判断T2
是否为T1的子树
 */

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-9.
 */

/*
搜遍较大的那棵树T1,每当T1的某个结点与T2的根结点匹配时，就调用treeMatch.
treeMatch方法会比较两棵子树，检查两者是否相同
 */
public class Program {


    boolean containsTree(TreeNode t1,TreeNode t2){
        if(t2==null)
            return true;
        return subTree(t1,t2);
    }

    private boolean subTree(TreeNode r1, TreeNode r2){
        if(r1 == null)
            return false;
        if(r1.val == r2.val)
            if(matchTree(r1,r2))
                return true;
        return (subTree(r1.left,r2) || subTree(r1.right,r2));
    }

    private boolean matchTree(TreeNode r1, TreeNode r2){

        if(r2==null && r1==null)
            return true;

        if(r1==null || r2==null)
            return false;

        if(r1.val != r2.val)
            return false;
        return (matchTree(r1.left,r2.left) && matchTree(r1.right,r2.right));

    }
}
