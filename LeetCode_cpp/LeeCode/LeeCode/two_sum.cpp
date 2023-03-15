#include <stdio.h>
#include <unordered_map>

class Solution
{
public:
	/// <summary>
	/// 两数之和【hashmap解法】
	/// </summary>
	/// <param name="nums"></param>
	/// <param name="target"></param>
	/// <returns></returns>
	std::vector<int> twoSum(std::vector<int>& nums, int target)
	{
		std::unordered_map<int, int> map;
		for (int i = 0; i < nums.size(); i++)
		{
			auto it = map.find(target - nums[i]);
			if (it != map.end())
			{
				return {i, it->second};
			}
			map.insert({ nums[i], i });
		}
		return {};
	}


	/// <summary>
	/// 暴力枚举
	/// </summary>
	/// <param name="nums"></param>
	/// <param name="target"></param>
	/// <returns></returns>
	std::vector<int> twoSum_violence(std::vector<int>& nums, int target)
	{
		for (int i = 0; i < nums.size(); i++)
		{
			for (int j = i + 1; j < nums.size(); j++)
			{
				if (nums[i] + nums[j] == target)
				{
					return { i, j };
				}
			}
		}
		return {};
	}
};