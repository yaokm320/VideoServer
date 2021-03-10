package com.example.test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yaokm
 * @date 2021/3/10 18:49
 *
 * 二叉树的层次遍历
 *
 */
public class testLevelOrder {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public List<List<Integer>> levelOrder(TreeNode root){

        // 用来存放遍历得到的结果
        ArrayList<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        // 设置一个队列,存放节点
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            // 存放每一层得到的结果
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                arrayList.add(node.val);
                if(node.left!= null){
                    queue.add(node.left);
                }
                if(node.right!= null){
                    queue.add(node.right);
                }
            }
            result.add(arrayList);
        }
        return result;
    }
}
