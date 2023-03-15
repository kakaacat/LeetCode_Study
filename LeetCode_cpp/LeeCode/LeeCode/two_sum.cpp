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
			int a = target - nums[i];
			auto it = map.find(a);
			if (it != map.end())
			{
				return {i, it->second};
			}
		}
	}
};