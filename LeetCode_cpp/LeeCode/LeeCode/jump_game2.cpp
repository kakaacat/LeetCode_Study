#include <iostream>
#include <vector>

class Solution
{
public:

	/// <summary>
	/// 贪心
	/// </summary>
	/// <param name="nums"></param>
	/// <returns></returns>
	int jump(std::vector<int>& nums)
	{
		int n = nums.size();
		int max_length = 0;
		int end = 0;
		int step = 0;
		for (int i = 0; i < n; i++)
		{
			//位置可达
			if (max_length >= i)
			{
				max_length = std::max(max_length, nums[i] + i);
				if (i == end) // 在子步骤内选择最优，更新下一个子步骤，然后step++；
				{
					end = max_length;
					step++;
				}
			}
		}
		return step;
	}
};