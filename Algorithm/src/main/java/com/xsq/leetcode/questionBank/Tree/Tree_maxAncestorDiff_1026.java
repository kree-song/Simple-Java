package src.com.xsq.leetcode.questionBank.Tree;


import com.xsq.leetcode.Node.TreeNode;

/**
 * 1026.节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先
 */
public class Tree_maxAncestorDiff_1026 {
    public static void main(String[] args) {

    }

    /**
     * 递归
     * 递的过程中，每个结点可以获取到当前结点的min、max，返回值代表当前子树的diff
     * O(n)、O(n)
     */
    public static int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public static int dfs(TreeNode root, int min, int max) {
        if (root == null) return 0;

        int diff = Math.max(Math.abs(root.val - min), Math.abs(root.val - max));//记录当前结点与min、max差值的最大值
        min = Math.min(root.val, min);//到当前结点的最小值
        max = Math.max(root.val, max);//到当前结点的最大值
        diff = Math.max(diff, dfs(root.left, min, max));//返回当前结点的左子树及本结点的diff最大值
        diff = Math.max(diff, dfs(root.right, min, max));//返回当前结点的diff最大值
        return diff;
    }
}
