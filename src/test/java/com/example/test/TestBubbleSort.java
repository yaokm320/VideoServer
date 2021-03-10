package com.example.test;

import java.util.Arrays;

/**
 * @author yaokm
 * @date 2021/3/10 20:05
 */
public class TestBubbleSort {
    public static void bubbleSort(int[] arr){
        if(arr == null) return;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean sentinel = false;
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    sentinel = true;
                }
            }
            if(!sentinel){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,4,2,7,33,12};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
