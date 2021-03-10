package com.example.test;


import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yaokm
 * @date 2021/3/10 18:27
 *
 * 测试栈和队列
 */
public class TestQueueStack {

    @Test
    /*
    * 测试栈操作，push(), pop(), peek()
    * */
    public void testStack(){
        // 测试栈
        Deque<Integer> stack = new LinkedList<>();
        // 入栈push()
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // 出栈pop()
        System.out.println(stack.pop());
        // 查看栈顶元素peek()
        System.out.println(stack.peek());
    }

    @Test
    /*
    * 测试队列操作，add(), remove(), element()
    * */
    public void testQueue(){
        Deque<Integer> queue = new LinkedList<>();
        // 队尾添加元素
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // 获取并清除队首元素
        System.out.println(queue.remove());
        // 获取队首元素
        System.out.println(queue.element());
    }

}
