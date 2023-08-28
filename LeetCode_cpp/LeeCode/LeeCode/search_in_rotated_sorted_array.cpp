#include <vector>
#include <iostream>

class Solution
{
public:
	/// <summary>
	/// ¶ş·Ö²éÕÒ
	/// </summary>
	/// <param name="nums"></param>
	/// <param name="target"></param>
	/// <returns></returns>
	int search(std::vector<int>& nums, int target)
	{
        int n = nums.size();
        if (n == 0) return -1;
        if (n == 1) return (nums[0] == target ? 0 : -1);

        int l = 0, r = n - 1;
        while (l <= r)
        {
            int mid = (r - l) / 2 + l;

            if (nums[mid] == target) return mid;

            if (nums[mid] < target)
            {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;

	}
};