package com.kaka.LC11_20.topic20;

/**
 * @Author : kaka
 * @Date: 2021-12-06 10:24
 *
 * @Topic: 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分
 *
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {
    /**
     * 1、动态规划
     *
     * 动态规划最重要的思想就是**利用上一个状态**, 对于本题而言就是: **到底要不要加上上一个状态f(i-1)的信息**,
     * 这完全取决于f(i-1)的**正负情况**, 这样我们就能得出了动态规划的递推公式: f(i)=max{f(i−1)+ai,ai}
     * 代码中的一个技巧就是对于**空间复杂度的优化**.
     * 当使用动态规划**只需要一个数**(并不需要整个dp数组)时, 我们就没必要将整个dp数组都保存下来,
     * 我们只需**用变量来记录下我们需要的某个量**即可, 这个优化方法在动态规划中还是非常常用的方法.
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int maxSubArray(int[] nums) {
        int max = 0;
        int ans = nums[0];
        for (int num : nums) {
            max = Math.max(max + num, num);
            ans = Math.max(ans, max);
        }
        return ans;
    }
    /**
     * 2、贪心算法
     *
     * 本题还可以利用贪心法来实现, **贪心的思想**是: 从左向右迭代, 一个个数字加过去如果sum<0,
     * 那说明加上它只会变得越来越小, 所以我们将sum置零后重新开始找子序串.
     * 在迭代的过程中要注意, 我们需要**用result来不断维持当前的最大子序和**, 因为sum的值是在不断更新的,
     * 所以我们要及时记录下它的最大值.
     * 有一个注意点是: 有的朋友可能觉得当**数组全是负数**的时候可能会出现问题,
     * 其实是没有问题的. 因为在sum不断遍历的过程中, 早已将最大值不断传给result, 即使sum一直是负数被不断置零也不用担心,
     * result还是会记录下最大的那个负数.
     */
    public int maxSubArray2(int[] nums){
        int sum = 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return result;
    }
    /**
     * 3、分治法——线段树
     *
     * 时间复杂度：假设我们把递归的过程看作是一颗二叉树的先序遍历，那么这颗二叉树的深度的渐进上界为 (logn)，
     * 这里的总时间相当于遍历这颗二叉树的所有节点，故总时间的渐进上界是 O(n)，故渐进时间复杂度为 O(n)
     * 空间复杂度：递归会使用 O(logn) 的栈空间，故渐进空间复杂度为 O(logn)。
     */
    public int maxSubAray3(int[] nums) {
        if (nums == null || nums.length <= 0) {     // 输入校验
            return 0;
        }
        int len = nums.length;// 获取输入长度
        return getInfo(nums, 0, len - 1).mSum;
    }

    class wtevTree { //线段树
        int lSum;// 以左区间为端点的最大子段和
        int rSum;// 以右区间为端点的最大子段和
        int iSum;// 区间所有数的和
        int mSum;// 该区间的最大子段和
        wtevTree(int l, int r, int i, int m) { // 构造函数
            lSum = l;
            rSum = r;
            iSum = i;
            mSum = m;
        }
    }

    // 通过既有的属性,计算上一层的属性,一步步往上返回,获得线段树
    wtevTree pushUp(wtevTree leftT, wtevTree rightT) {
        // 新子段的lSum等于左区间的lSum或者左区间的 区间和 加上右区间的lSum
        int l = Math.max(leftT.lSum, leftT.iSum + rightT.lSum);
        // 新子段的rSum等于右区间的rSum或者右区间的 区间和 加上左区间的rSum
        int r = Math.max(leftT.rSum + rightT.iSum, rightT.rSum);
        // 新子段的区间和等于左右区间的区间和之和
        int i = leftT.iSum + rightT.iSum;
        // 新子段的最大子段和,其子段有可能穿过左右区间,或左区间,或右区间
        int m = Math.max(leftT.rSum + rightT.lSum, Math.max(leftT.mSum, rightT.mSum));
        return new wtevTree(l, r, i, m);
    }

    // 递归建立和获得输入区间所有子段的结构
    wtevTree getInfo(int[] nums, int left, int right) {
        if (left == right) {     // 若区间长度为1,其四个子段均为其值
            return new wtevTree(nums[left], nums[left], nums[left], nums[left]);
        }
        int mid = (left + right) >> 1;  // 获得中间点mid,右移一位相当于除以2,运算更快
        wtevTree leftT = getInfo(nums, left, mid);
        wtevTree rightT = getInfo(nums, mid + 1, right);    //mid+1,左右区间没有交集。
        return pushUp(leftT, rightT);   //递归结束后,做最后一次合并
    }

}
