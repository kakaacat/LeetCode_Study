#include <iostream>
#include <vector>

class Solution
{
public:

	/// <summary>
	/// ̰��
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
			//λ�ÿɴ�
			if (max_length >= i)
			{
				max_length = std::max(max_length, nums[i] + i);
				if (i == end) // ���Ӳ�����ѡ�����ţ�������һ���Ӳ��裬Ȼ��step++��
				{
					end = max_length;
					step++;
				}
			}
		}
		return step;
	}
};