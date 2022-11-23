package com.ch01;

//给你一个整数数组 nums 以及两个整数 lower 和 upper 。求数组中，值位于范围 [lower, upper] （包含 lower 和 upper）之内的 区间和的个数 。
//
//        区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/count-of-range-sum
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class Code_01_CountRangeSum {


    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return process(nums, 0, nums.length - 1, lower, upper);
    }

    public int process(int[] nums, int l, int r, int lower, int upper) {
        if (l == r) {
            return nums[l] >= lower && nums[l] <= upper ? 1 : 0;
        }
        int mid = l + ((r - l) >> 1 + 1);
        return process(nums, l, mid, lower, upper) + process(nums, mid + 1, r, lower, upper) + merge(nums, l, mid, r, lower, upper);
    }

    public int merge(int[] nums, int l, int mid, int r, int lower, int upper) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = r;
        int k = 0;
        while (p1 <= mid && p2 <= r) {
            help[k++] = nums[p1] > nums[p2] ? nums[p2++] : nums[p1++];
        }
        while (p1 <= mid) {
            help[k++] = nums[p1++];
        }
        while (p2 <= r) {
            help[k++] = nums[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
