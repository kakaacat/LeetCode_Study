package com.kaka.LC21_30.topic29;

import com.kaka.LC21_30.topic27.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author : kaka
 * @Date: 2021-12-14 19:52
 *
 * @Description: 二叉树的最近公共祖先
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，
 * 最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 *
 */
public class LowestCommonAncestorofABinaryTree {
    /**
     * 递归
     *
     * 时间复杂度：O(N)，其中 N 是二叉树的节点数。
     * 二叉树的所有节点有且只会被访问一次，因此时间复杂度为 O(N)
     * 空间复杂度：O(N) ，其中 N 是二叉树的节点数。
     * 递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 N，因此空间复杂度为 O(N)。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return null;
        }

        //此节点就是 p 或 q。那么最近祖先结点就是此节点
        if (root == p || root == q){
            return root;
        }
        //后序遍历，左右根，
        TreeNode lSon = lowestCommonAncestor(root.left, p, q);
        TreeNode rSon = lowestCommonAncestor(root.right, p, q);

        //此节点的左右子节点有p和q。那么此节点就是最近祖先结点
        if (lSon != null && rSon != null){
            return root;
        }

        //此节点的左右子节点中有一个有 p 或 q。返回有 p 或 q的子节点
        return lSon == null ? rSon : lSon;
    }

    /**
     * 哈希表
     */
    Map<Integer, TreeNode> parents = new HashMap<Integer, TreeNode>();
    //visited保存 q以及 q 的祖先节点的值
    Set<Integer> visited = new HashSet<Integer>();

    //深度优先搜索
    public void dfs(TreeNode root){
        if (root.left != null){
            parents.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null){
            parents.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q){
//        if (root == null){
//            return null;
//        }
//        if (root == p || root == q){
//            return root;
//        }
        dfs(root);
        while (p != null){
            visited.add(p.val);
            p = parents.get(p.val);
        }
        while (q != null){
            if (visited.contains(q.val)){
                return q;
            }
            q = parents.get(q.val);
        }
        return null;
    }
}
