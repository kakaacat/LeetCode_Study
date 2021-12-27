package com.kaka.LC41_50.topic41;

import com.kaka.LC21_30.topic27.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Author : kaka
 * @Date: 2021-12-27 11:18
 *
 * @Description: 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    /**
     * 1.递归
     *
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     * 空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     */
    public List<Integer> inorderTraversal1(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if (root == null){
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    /**
     * 2.迭代
     *
     * 时间复杂度：O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
     * 空间复杂度：O(n)。空间复杂度取决于栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
     *
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    /**
     * Morris 中序遍历
     *
     * Morris 遍历算法是另一种遍历二叉树的方法，它能将非递归的中序遍历空间复杂度降为 O(1)。
     * Morris 遍历算法整体步骤如下（假设当前遍历到的节点为 x）：
     * 如果 x 无左孩子，先将 x 的值加入答案数组，再访问 x 的右孩子，即 x=x.right。
     * 如果 x 有左孩子，则找到 x 左子树上最右的节点（即左子树中序遍历的最后一个节点，x 在中序遍历中的前驱节点），我们记为 \textit{predecessor}predecessor。根据 \textit{predecessor}predecessor 的右孩子是否为空，进行如下操作。
     * 如果 predecessor 的右孩子为空，则将其右孩子指向 x，然后访问 x 的左孩子，即 x=x.left。
     * 如果 predecessor 的右孩子不为空，则此时其右孩子指向 x，说明我们已经遍历完 x 的左子树，我们将 predecessor 的右孩子置空，将 x 的值加入答案数组，然后访问 x 的右孩子，即 x=x.right。
     * 重复上述操作，直至访问完整棵树。
     *
     * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
     */
    public List<Integer> morris(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        TreeNode predecessor = null;
        while (root != null){
            if (root.left != null){
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null){
                    predecessor.right = root;
                    root = root.left;
                } else {      // 第二次访问了.说明左子树已经访问完了，我们需要断开链接.接下来应该访问其右子树
                    ans.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            } else {    //没有左子树，直接访问该节点，再访问右子树
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

}
