#include <iostream>
#include <vector>

class Solution
{
public:
	//动态规划
	int maxSubArray(std::vector<int>& nums)
	{
		int pre = 0, max_subarray = INT_MIN;
		for (auto& i : nums)
		{
			pre = std::max(pre + i, i);
			max_subarray = std::max(max_subarray, pre);
		}

		return max_subarray;
	}
	//贪心算法
	int maxSubarray(std::vector<int>& nums)
	{
		int sum = 0, max_subarray = INT_MIN;
		for (auto& i : nums)
		{
			sum += i;
			max_subarray = std::max(max_subarray, sum);
			if (sum < 0)
			{
				sum = 0;
			}
		}

		return max_subarray;
	}
};
