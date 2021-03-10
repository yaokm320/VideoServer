package com.example.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yaokm
 * @date 2021/3/10 15:33
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // 向hashMap中存放元素，put()方法
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        hashMap.put(3, 300);

        // 从hashMap中取出元素，get()方法
        System.out.println("从HashMap中取出一个元素" + hashMap.get(2));

        // 遍历hashMap元素, keySet()方法
        for (Integer i : hashMap.keySet()) {
            System.out.println(i + "--->" + hashMap.get(i));
        }

        // 遍历hashMap元素, keySet()方法
        for (Integer i : hashMap.values()) {
            System.out.println(i);
        }

        // 遍历hashMap元素, EntrySet()方法
        for (Map.Entry<Integer, Integer> entry: hashMap.entrySet()) {
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

        // 获取hashMap中元素的个数
        System.out.println("元素个数："+ hashMap.size());

        // 从hashMap中移除元素，remove()方法
        System.out.println("从hashMap中移除元素"+ hashMap.remove(1));

    }
}

