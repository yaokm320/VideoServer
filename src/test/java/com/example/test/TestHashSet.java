package com.example.test;

import java.util.HashSet;

/**
 * @author yaokm
 * @date 2021/3/10 15:42
 */
public class TestHashSet {
    public static void main(String[] args) {

        HashSet<Integer> hashSet = new HashSet<>();

        // 向hashSet中插入元素add()
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);

        // 遍历hashSet元素
        for (Integer i : hashSet) {
            System.out.println(i);
        }

        // 获取hashSet中元素的个数size()
        System.out.println(hashSet.size());

        // 移除hashSet中的元素remove()
        System.out.println("移除hashSet中的元素"+hashSet.remove(1));

    }
}
