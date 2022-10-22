package com.datastruct.leetcode;

import com.datastruct.zuo.common.ArrayUtils;
import com.datastruct.zuo.common.TreeNode;
import com.datastruct.zuo.common.TreeUtil;

public class LeetCode_124_MaxPathSum {


    private static int ans = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int[] array = ArrayUtils.generateRandomArray(10, 100, -1);

        ArrayUtils.printArr(array);
        TreeNode root = TreeUtil.createTree(ArrayUtils.intToInteger(array));
        TreeUtil.printNode(root);

        int i = maxPathSum(root);
        System.out.println(i);
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);
        ans = Math.max(ans, left + right + root.value);
        return Math.max(left, right) + root.value;
    }
}
