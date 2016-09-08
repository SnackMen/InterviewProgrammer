package com.ws.program2;

/*
方法二：
    算法改进，仔细查看上面的方法，会发现，getheight不仅可以检查高度，还可以检查
    这棵树是否平衡。那么，我们发现子树不平衡时可以直接返回-1

    时间复杂度：O（N)
    空间复杂度：O（H）
 */

import com.ws.node.TreeNode;

/**
 * Created by laowang on 16-9-8.
 */
public class Program {
    private static int checkHeight(TreeNode root) {
        if (root == null)
            return 0;
    /*
    检查左子树是否平衡
     */

        int lefHeight = checkHeight(root.left);
        if(lefHeight == -1)
            return -1;

        /*
        检查右子树
         */

        int rightHeight = checkHeight(root.right);
        if(rightHeight == -1)
            return -1;

        /*
        检查当前结点是否平衡
         */

        int heightDiff = lefHeight - rightHeight;
        if(Math.abs(heightDiff) > 1)
            return -1;
        else
            return Math.max(lefHeight,rightHeight)+1;//返回当前结点的子树的高度
    }

    public static boolean isBalanced(TreeNode root){
       return checkHeight(root) == -1;
    }

}
