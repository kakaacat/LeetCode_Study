#include <iostream>
#include <vector>


/// <summary>
/// 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
/// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
/// 判断你是否能够到达最后一个下标。
/// </summary>
class Solution {
public:
	/// <summary>
	/// 动态规划
	/// 1、dp[i]表示在下表i初能够跳跃的最大值
	/// 2、对于dp[i]，它等于dp[i-1]跳一格到达i后剩余的步数，和nums[i]的最大值
	///	   则转移方程：dp[i] = max(dp[i-1]-1, nums[i])
	/// 3、边界条件：dp[0] = nums[0]
	/// 4、每次循环开始，判断dp[i-1]是否为0，若是则false，循环结束返回true
	/// 5、因为转移状态数组dp之和前一位有关，因此可以用滚动数组简化空间复杂度
	/// </summary>
	/// <param name="nums"></param>
	/// <returns></returns>
	bool canJump(std::vector<int>& nums) {
		int n = nums.size();
		if (n == 1) return true;
		int a = nums[0];
		for (int i = 1; i < n; i++)
		{
			if (a == 0) return false;
			a = std::max(a - 1, nums[i]);
		}
		return true;
	}


	/// <summary>
	/// 贪心
	/// </summary>
	/// <param name="nums"></param>
	/// <returns></returns>
	bool canJump2(std::vector<int>& nums) {
		int n = nums.size();
		int max_length = 0;
		for (int i = 0; i < n; i++)
		{
			if (max_length >= i) //i位置可达
			{
				max_length = std::max(max_length, nums[i] + i); //更新最大可达
				if (max_length >= n - 1)	//最大可达超出最后一位
				{
					return true;
				}
			}
		}
		return false;
	}
};