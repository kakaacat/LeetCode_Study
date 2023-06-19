#include <vector>
#include <iostream>

class Solution
{
public:
	/// <summary>
	/// 二分查找
	/// </summary>
	/// <param name="nums"></param>
	/// <param name="target"></param>
	/// <returns></returns>
	int search(std::vector<int>& nums, int target)
	{
		int n = nums.size();
		if (!n)
		{
			return -1;
		}
		if (n == 1)
		{
			return (target == nums[0] ? 0 : -1);
		}
		int l = 0, r = n - 1;
		while (l <= r)
		{
			int mid = (l + r) / 2;
			if (nums[mid] == target)
			{
				return (mid);
			}
			//左侧有序
			if (nums[0] <= nums[mid])
			{
				if (nums[0] <= target && target < nums[mid])
				{
					r = mid - 1;
				}
				else {
					l = mid + 1;
				}
			}
			//右侧有序
			else {
				if (nums[mid] < target && target <= nums[n-1])
				{
					l = mid + 1;
				}
				else {
					r = mid - 1;
				}
			}
		}
		return (-1);

	}
};