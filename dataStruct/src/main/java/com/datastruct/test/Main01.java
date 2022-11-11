package com.datastruct.test;

import com.datastruct.zuo.common.TreeNode;

public class Main01 {

    public void diGui(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        diGui(root.left);
        diGui(root.right);
    }


    public static void main(String[] args) {

    }
}
