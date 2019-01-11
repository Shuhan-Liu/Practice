package Structure;

/**
 * Created by shuhanliu on 10/10/18.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

//    Not implemented because only given level order is not enough
//
//    public TreeNode constructTreeFromLevelOrder(int[] arr) {
//
//        return null;
//    }
}
