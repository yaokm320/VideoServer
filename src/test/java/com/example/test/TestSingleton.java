package com.example.test;

import org.apache.catalina.authenticator.SingleSignOn;

/**
 * 懒汉式
 * @author yaokm
 * @date 2021/3/9 20:53
 */
public class TestSingleton {

    private TestSingleton(){}

    // volatile保证立即可见行，防止指令重排
    private static volatile TestSingleton singleton = null;

    // 懒汉式
    public static TestSingleton getInstance(){
        if(singleton == null){
            singleton = new TestSingleton();
        }
        return singleton;
    }

    // 双重检查懒汉式
    public static TestSingleton getInstance2(){
        if(singleton == null){
            synchronized (TestSingleton.class){
                if(singleton == null){
                    singleton = new TestSingleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {
        TestSingleton instance = TestSingleton.getInstance();
        System.out.println(instance);
    }

}
