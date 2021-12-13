package com.kaka.LC21_30.topic27;

import java.util.*;

/**
 * @Author : kaka
 * @Date: 2021-12-13 10:10
 *
 * @Description: 二叉树的锯齿形遍历
 *
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class BTreeZigzagOrderTraversal {
    /**
     * 1.双端队列
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root){
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        //标记从左还是从右开始
        boolean isLeftOrder = true;

        while(!nodeQueue.isEmpty()){
            //levelList用于存放本层的结点值
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            //依次取出队列中的结点
            for (int i = 0; i < size; i++) {
                TreeNode curNode = nodeQueue.poll();
                //判断左右然后加入levelList
                if (isLeftOrder){
                    levelList.offerLast(curNode.val);
                }else{
                    levelList.offerFirst(curNode.val);
                }
                //将下一层的结点加入队列
                if (curNode.left != null){
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null){
                    nodeQueue.offer(curNode.right);
                }
            }
            //一层遍历完成，访问顺序反转
            ans.add(new LinkedList<Integer>(levelList));
            isLeftOrder = !isLeftOrder;
        }

        return ans;
    }
    /**
     *  1.2 直接遍历，然后对需要反转的层反转
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean reverse = false;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> tempList = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                tempList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            if (reverse) {
                Collections.reverse(tempList);
            }

            reverse = !reverse;
            ans.add(tempList);
        }
        return ans;
    }
    /**
     * 2.双栈
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null){
            return ans;
        }
        Stack<TreeNode> leftOrderStack = new Stack<>();
        Stack<TreeNode> rightOrderStack = new Stack<>();
        boolean isLeftOrder = true;

        leftOrderStack.push(root);

        while (!leftOrderStack.empty() || !rightOrderStack.empty()){
            List<Integer> levelList = new LinkedList<>();
            int size = 0;
            if (!leftOrderStack.empty()){
                size = leftOrderStack.size();
            }else if(!rightOrderStack.empty()){
                size = rightOrderStack.size();
            }

            for (int i = 0; i < size; i++) {
                //左序
                if (isLeftOrder){
                    TreeNode curNode = leftOrderStack.pop();
                    levelList.add(curNode.val);
                    if (curNode.left != null){
                        rightOrderStack.push(curNode.left);
                    }
                    if (curNode.right != null){
                        rightOrderStack.push(curNode.right);
                    }
                }else{  //右序
                    TreeNode curNode = rightOrderStack.pop();
                    levelList.add(curNode.val);
                    if (curNode.right != null){
                        leftOrderStack.push(curNode.right);
                    }
                    if (curNode.left != null){
                        leftOrderStack.push(curNode.left);
                    }
                }
            }

            ans.add(new LinkedList<Integer>(levelList));
            isLeftOrder = !isLeftOrder;
        }

        return ans;
    }

}
