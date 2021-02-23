package Common;

public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
    public boolean hasLeft()
    {
        if (this.left!=null) return true;
        else return false;
    }

    public boolean hasright()
    {
        if (this.right!=null) return true;
        else return false;
    }
    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    public boolean isExist(TreeNode node)
    {
        if (node!=null) return true;
        else return false;
    }
    public static TreeNode initTree()
    {
//                        1
//                      /   \
//                    2      3
//                  /   \  /   \
//                4     5 6     7
//              /   \
//             8    9
        TreeNode treeNode = new TreeNode(1);
        treeNode.left= new TreeNode(2);
        treeNode.right= new TreeNode(3);
        treeNode.left.left= new TreeNode(4);
        treeNode.left.right= new TreeNode(5);
        treeNode.right.left= new TreeNode(6);
        treeNode.right.right= new TreeNode(7);
        treeNode.left.left.left= new TreeNode(8);
        treeNode.left.left.right= new TreeNode(9);
        return treeNode;
    }
}