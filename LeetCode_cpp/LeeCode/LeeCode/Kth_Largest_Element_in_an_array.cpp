#include <vector>
#include <time.h>


class Solution
{
public:
	void quickPartition(std::vector<int>& nums, int start, int end, int target)
	{
		srand(time(nullptr));
		int random = rand() % (end - start + 1) + start;
		int base = nums[random];
		
		std::swap(nums[random], nums[start]);
		int index = start;

		// 从待快排区间的第二个元素开始，依次与base比较，如果大于等于base则将该元素
		// 交换到index + 1位置，index++，使得最终index前面的元素都比base大。
		for (int i = start + 1; i <= end; i++)
		{
			if (nums[i] >= base)
			{
				std::swap(nums[index + 1], nums[i]);
				index++;
			}
		}
		std::swap(nums[start], nums[index]);

		// 如果index小于target，需要在右边区间继续快排查找，否则到在边区间查找，
		// 如果等于已经找到目标值不需要递归，这里这么做优化了传统快排的复杂度。
		if (index < target)
		{
			quickPartition(nums, index + 1, end, target);
		}
		else if (index > target)
		{
			quickPartition(nums, start, index - 1, target);
		}
	}

	int findKthLargest(std::vector<int>& nums, int k)
	{
		quickPartition(nums, 0, nums.size() - 1, k - 1);
		return nums[k - 1];
	}

};