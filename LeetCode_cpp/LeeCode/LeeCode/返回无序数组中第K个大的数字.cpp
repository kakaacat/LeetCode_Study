#include <iostream>
#include <vector>
#include <random>

using namespace std;

int quickSort(vector<int>& nums, int l, int r, int k)
{
	if (l == r) return nums[l];

	int random = rand() % (r - l + 1) + l;
	int base = nums[random];
	swap(nums[random], nums[l]);
	int index = l;

	for (int i = l + 1; i <= r; i++)
	{
		if (nums[i] < base) 
		{
			swap(nums[i], nums[index + 1]);
			index++;
		}
	}
	swap(nums[l], nums[index]);

	if (index == k)
	{
		return nums[index];
	}
	else if (index > k)
	{
		return quickSort(nums, l, index, k);
	}
	else
	{
		quickSort(nums, index + 1, r, k);
	}	
}

int main()
{
	vector<int> nums = { 1,3,2,4,5 };
	int k = 2;

	cout << quickSort(nums, 0, nums.size() - 1, nums.size() - k);

	return 0;
}