package com.ch01;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/30 10:45 上午
 * FileName: Code_01_IsSameTree
 * Description: com.ch01 判断树的结构是否一样
 */
public class Code_01_IsSameTree {

    public class TreeNode {
        int val;
        InorderTraversal.TreeNode left;
        InorderTraversal.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, InorderTraversal.TreeNode left, InorderTraversal.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        return false;
    }
}
