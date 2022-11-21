#include <iostream>
#include <vector>

class Solution
{
public:
	//¶¯Ì¬¹æ»®
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
};
