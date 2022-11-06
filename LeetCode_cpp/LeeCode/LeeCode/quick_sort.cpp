#include <vector>
class Solution
{
public:
	void quickSort(std::vector<int>& nums, int l, int r)
	{
		if (l < r)
		{
			//随机选择阈值
			int random = rand() % (r - l + 1) + l;
			int base = nums[random];
			std::swap(nums[random], nums[l]);
			int index = l; //用于记录交换位置
			for (int i = l + 1; i <= r; i++)
			{
				if (nums[i] < base)
				{
					std::swap(nums[i], nums[index + 1]);
					index++;
				}
			}
			std::swap(nums[l], nums[index]);

			quickSort(nums, l, index);
			quickSort(nums, index +	1, r);
		}
	}


	std::vector<int> sortArray(std::vector<int>& nums)
	{
		quickSort(nums, 0, nums.size() - 1);
		return nums;
	}

};
