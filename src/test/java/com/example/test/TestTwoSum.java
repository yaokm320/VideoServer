package com.example.test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yaokm
 * @date 2021/3/10 15:55
 */
public class TestTwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = target-nums[i];
            if(hashMap.containsKey(a)){
                return new int[]{i, hashMap.get(a)};
            }else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int[] ints = twoSum(arr, 6);
        System.out.println(Arrays.toString(ints));
    }
}

