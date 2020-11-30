package tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * modified by @author Vrushabh Joshi last on 30-11-2020 09:51
 */
class DFSTraversal {

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        Integer val;

        TreeNode(Integer val) {
            this.val = val;
            left = right = null;
        }
    }
    static TreeNode root;

    public static void main(String[] args) {
        DFSTraversal dfsTraversal = new DFSTraversal();
        dfsTraversal.createTree();

        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        preOrder(root, pre);
        inOrder(root, in);
        postOrder(root, post);

    }

    public static void postOrder(TreeNode root, List<Integer> res) {
        if (root != null) {

            if (root.left != null) {
                postOrder(root.left, res);
            }
            if (root.right != null) {
                postOrder(root.right, res);
            }
            res.add(root.val);

        }
    }

    public static void preOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null) {
                preOrder(root.left, res);
            }
            if (root.right != null) {
                preOrder(root.right, res);
            }
        }
    }

    public static void inOrder(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                inOrder(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                inOrder(root.right, res);
            }

        }
    }

    public void createTree() {
        TreeNode head = new TreeNode(1);
        root = head;
        TreeNode LsecondRoot = new TreeNode(2);
        TreeNode RsecondRoot = new TreeNode(3);
        head.left = LsecondRoot;
        head.right = RsecondRoot;
        TreeNode LthirdRoot = new TreeNode(4);
        LthirdRoot.left = new TreeNode(8);
        TreeNode RthirdRoot = new TreeNode(5);
        RthirdRoot.left = new TreeNode(9);
        TreeNode L1thirdRoot = new TreeNode(6);
        TreeNode R1thirdRoot = new TreeNode(7);
        R1thirdRoot.right = new TreeNode(10);
        LsecondRoot.left = LthirdRoot;
        LsecondRoot.right = RthirdRoot;
        RsecondRoot.left = L1thirdRoot;
        RsecondRoot.right = R1thirdRoot;

    }
}