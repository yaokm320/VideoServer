package com.example.test;

import java.util.Arrays;

/**
 * 堆排序
 * @author yaokm
 * @date 2021/3/8 10:07
 */
public class TestHeapSort {

    public static void heapSort(int[] arr) {

        int len = arr.length - 1;
        int beginIndex = (len - 1) / 2;
        // 从非一个非叶子节点构建大顶堆
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(arr, i, len);
        }
        // 堆排序，其中伴随着堆的调整
        for (int i = len; i > 0; i--) {
            swap(arr, 0, i);
            maxHeapify(arr, 0, i - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void maxHeapify(int[] arr, int index, int len) {
        int li = 2 * index + 1;
        int ri = li + 1;
        int cMax = li;
        if (li > len)
            return;
        if (ri <= len && arr[ri] > arr[li])
            cMax = ri;
        if (arr[cMax] > arr[index]) {
            swap(arr, cMax, index);
            maxHeapify(arr, cMax, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,49,2,4,22,90,12,34};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

