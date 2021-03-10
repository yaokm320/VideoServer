package com.example.test;

/**
 * @author yaokm
 * @date 2021/3/10 14:22
 */
public class TestTreePathSum {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right ==null){
            return sum == root.val;
        }
        return hasPathSum(root.left, sum- root.val) || hasPathSum(root.right, sum- root.val);
    }


}
