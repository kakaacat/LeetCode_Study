#include <iostream>
#include <vector>


/// <summary>
/// ����һ���Ǹ��������� nums �������λ������� ��һ���±� ��
/// �����е�ÿ��Ԫ�ش������ڸ�λ�ÿ�����Ծ����󳤶ȡ�
/// �ж����Ƿ��ܹ��������һ���±ꡣ
/// </summary>
class Solution {
public:
	/// <summary>
	/// ��̬�滮
	/// 1��dp[i]��ʾ���±�i���ܹ���Ծ�����ֵ
	/// 2������dp[i]��������dp[i-1]��һ�񵽴�i��ʣ��Ĳ�������nums[i]�����ֵ
	///	   ��ת�Ʒ��̣�dp[i] = max(dp[i-1]-1, nums[i])
	/// 3���߽�������dp[0] = nums[0]
	/// 4��ÿ��ѭ����ʼ���ж�dp[i-1]�Ƿ�Ϊ0��������false��ѭ����������true
	/// 5����Ϊת��״̬����dp֮��ǰһλ�йأ���˿����ù�������򻯿ռ临�Ӷ�
	/// </summary>
	/// <param name="nums"></param>
	/// <returns></returns>
	bool canJump(std::vector<int>& nums) {
		int n = nums.size();
		if (n == 1) return true;
		int a = nums[0];
		for (int i = 1; i < n; i++)
		{
			if (a == 0) return false;
			a = std::max(a - 1, nums[i]);
		}
		return true;
	}


	/// <summary>
	/// ̰��
	/// </summary>
	/// <param name="nums"></param>
	/// <returns></returns>
	bool canJump2(std::vector<int>& nums) {
		int n = nums.size();
		int max_length = 0;
		for (int i = 0; i < n; i++)
		{
			if (max_length >= i) //iλ�ÿɴ�
			{
				max_length = std::max(max_length, nums[i] + i); //�������ɴ�
				if (max_length >= n - 1)	//���ɴﳬ�����һλ
				{
					return true;
				}
			}
		}
		return false;
	}
};