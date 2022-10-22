package com.datastruct.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.datastruct.zuo.gra.Code03_DFS.dfs;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
@Slf4j
public class LeetCode_46_permute {

    public static void main(String[] args) {
        LeetCode_46_permute leetCode_46_permute = new LeetCode_46_permute();
        List<List<Integer>> permute = leetCode_46_permute.permute(new int[]{1, 2, 3});
        log.info("result={}", permute);
    }


    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        Set<List<Integer>> result = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, "", visited, result);
        return null;
    }

    private void dfs(int[] nums, String s, boolean[] visited, Set<List<Integer>> result) {
        if (s.length() == nums.length) {
            ArrayList<Integer> objects = new ArrayList<>();
            for (int i = 0; i < s.toCharArray().length; i++) {
                objects.add(nums[i]);
            }
            result.add(objects);
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(nums, s + nums[i], visited, result);
            visited[i] = false;
        }
    }
}
