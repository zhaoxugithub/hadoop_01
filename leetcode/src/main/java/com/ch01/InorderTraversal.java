package com.ch01;


import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (C), 2017-2021, 赵旭
 * Author: serendipity
 * Date: 2021/8/30 10:14 上午
 * FileName: InorderTraversal
 * Description: com.ch01
 */
public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }


        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        inorder(root, resultList);
        return resultList;
    }

    public void inorder(TreeNode root, List<Integer> resultList) {
        if (root == null) {
            return;
        }
        inorder(root.left, resultList);
        resultList.add(root.val);
        inorder(root.right, resultList);
    }


}
