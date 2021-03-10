package com.example.test;

import java.util.Arrays;

/**
 * @author yaokm
 * @date 2021/3/9 20:19
 */
public class TestQuickSort {

    public static int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] > tmp) right--;
            arr[left] = arr[right];
            while (left < right && arr[left] < tmp) left++;
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    public static void quickSort(int[] arr, int li, int ri) {
        if (li < ri) {
            int index = partition(arr, li, ri);
            quickSort(arr, li, index - 1);
            quickSort(arr, index + 1, ri);
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 32, 2, 85, 34, 23};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }
}
