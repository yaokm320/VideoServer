package com.example.test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yaokm
 * @date 2021/3/10 15:29
 *
 *
 * 使用两个栈模拟队列
 */
class TestMyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public TestMyQueue() {
        inStack = new LinkedList<Integer>();
        outStack = new LinkedList<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            in2out();
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    private void in2out() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
