package com.example.test;

/**
 * @author yaokm
 * @date 2021/3/10 15:48
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("nanjing");
        stringBuilder.append("jiangsu");

        stringBuilder.replace(0,2, "AAAA");
        stringBuilder.delete(0,2);

        System.out.println(stringBuilder);

        String s1 = String.format("jiangsu%s", "江苏");
        System.out.println(s1);
    }
}
