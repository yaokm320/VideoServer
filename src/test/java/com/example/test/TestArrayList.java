package com.example.test;

import java.util.ArrayList;

/**
 * @author yaokm
 * @date 2021/3/10 15:45
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // 添加元素add（）
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        // 遍历arrayList
        for (Integer i: arrayList ) {
            System.out.println(i);
        }

        // 计算元素个数size()
        System.out.println(arrayList.size());

        // 删除元素remove()
        System.out.println(arrayList.remove(1));
    }
}
