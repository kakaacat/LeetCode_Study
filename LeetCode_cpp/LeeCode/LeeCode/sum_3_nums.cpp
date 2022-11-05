#include <iostream>
#include <vector>
#include <algorithm>

class Soulation
{
public:
	std::vector<std::vector<int>> threeSum(std::vector<int>& nums)
	{
		std::vector<std::vector<int>> ans;
		if (nums.size() < 3 || nums.empty())
		{
			return ans; //����
		}

		int n = nums.size();
		//����
		std::sort(nums.begin(), nums.end());
		for (int i = 0; i < n; i++)
		{
			if (nums[i] > 0)
			{
				return ans;
			}
			// ��СԪ��ȥ�أ�
			if (i > 0 && nums[i] == nums[i-1])
			{
				continue;
			}
			int l = i + 1;
			int r = n - 1;
			while (l < r)
			{
				int x = nums[i] + nums[l] + nums[r];
				//�����������洢������ȥ�أ�˫�˶��Ƶ���һ��λ��
				if (x == 0)
				{
					ans.push_back({nums[i], nums[l], nums[r]});
					//����ͬһ��nums[i]��ȥ���ظ���Ԫ��
					while (l < r && nums[l] == nums[l + 1])
					{
						l++;
					}
					l++;
					while (l < r && nums[r] == nums[r - 1])
					{
						r--;
					}
					r--;
				}
				else if (x < 0)
				{
					l++;
				}
				else
				{
					r--;
				}
			}
		}
		return ans;
	}

};