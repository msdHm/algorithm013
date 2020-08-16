package week1;

import java.util.HashMap;
import java.util.Map;

public class HomeWork {
    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    // public TreeNode result;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     existTarget(root, p.val, q.val);
    //     return result;
    // }

    // public boolean existTarget(TreeNode root, int pValue, int qValue) {
    //     if (root == null) {
    //         return false;
    //     }
    //     boolean leftExist = existTarget(root.left, pValue, qValue);
    //     boolean rightExist = existTarget(root.right, pValue, qValue);
    //     int rootValue = root.val;
    //     if ((leftExist && rightExist) ||
    //         ((rootValue == pValue || rootValue == qValue) && (leftExist || rightExist))) {
    //             result = root;
    //     }
    //     return leftExist || rightExist || (rootValue == pValue || rootValue == qValue);
    // }

    // 方法二
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if (root == null || root == p || root == q) {
    //         return root;
    //     }
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     if (left == null) {
    //         return right;
    //     }
    //     if (right == null) {
    //         return left;
    //     }
    //     return root;
    // }

    // // 方法三 12ms
    private Map<Integer, TreeNode> parentMap = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.getParentMap(root);
        while (p != null) {
            visited.add(p.val);
            p = parentMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parentMap.get(q.val);
        }
        return null;
    }

    public void getParentMap(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left.val, root);
            getParentMap(root.left);
        }
        if (root.right != null) {
            parentMap.put(root.right.val, root);
            getParentMap(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     *
     * 示例:
     *
     * 输入: n = 4, k = 2
     * 输出:
     * [
     *   [2,4],
     *   [3,4],
     *   [2,3],
     *   [1,2],
     *   [1,3],
     *   [1,4],
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combinations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int n, k;
    public List<List<Integer>> result = new LinkedList();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        getAns(1, new LinkedList<Integer>());
        return result;
    }

    public void getAns(int first, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            result.add(new LinkedList(curr));
        }
        for (int i = first; i <= n; i++) {
            curr.add(i);
            getAns(i + 1, curr);
            curr.removeLast();
        }
    }

}
