package tree;

import Common.TreeNode;

public class BinaryTreeHeight {

    public static void main(String[] args) {
        System.out.println("Height is: "+new BinaryTreeHeight().findHeight(TreeNode.initTree()));
    }
    int findHeight(TreeNode root)
    {
        if (root == null) return -1;
        int left=findHeight(root.getLeft());
        int right=findHeight(root.getRight());
        return Math.max(left,right)+1;
    }

}