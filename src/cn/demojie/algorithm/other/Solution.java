package cn.demojie.algorithm.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        twoSumTest();
    }

    /**
     * 找出数组相加等于 target 的两个数字
     */
    static void twoSumTest() {
        int[] nums = {2, 7, 2, 7, 1, 11, 15, 8};
        int target = 9;
        List<List<Integer>> arrayLists = twoSum(nums, target);
        System.out.println(arrayLists);
    }

    /**
     * HashMap: <target - num, num>
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return Collections.emptyList();
        }
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList;

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Integer value = map.remove(num);
                subList = new ArrayList<>();
                subList.add(value);
                subList.add(num);
                result.add(subList);
            } else {
                map.put(target - num, num);
            }
        }
        return result;
    }

    /**
     * 找出下标
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        if (null == nums || nums.length <= 1) {
            return new int[0];
        }
        int len = nums.length;
        // map内容：<补数, 下标>
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                Integer complementIndex = map.remove(num);
                result[0] = complementIndex;
                result[1] = i;
            } else {
                map.put(target - num, i);
            }
        }
        return result;
    }
}
