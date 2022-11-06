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

		// �Ӵ���������ĵڶ���Ԫ�ؿ�ʼ��������base�Ƚϣ�������ڵ���base�򽫸�Ԫ��
		// ������index + 1λ�ã�index++��ʹ������indexǰ���Ԫ�ض���base��
		for (int i = start + 1; i <= end; i++)
		{
			if (nums[i] >= base)
			{
				std::swap(nums[index + 1], nums[i]);
				index++;
			}
		}
		std::swap(nums[start], nums[index]);

		// ���indexС��target����Ҫ���ұ�����������Ų��ң������ڱ�������ң�
		// ��������Ѿ��ҵ�Ŀ��ֵ����Ҫ�ݹ飬������ô���Ż��˴�ͳ���ŵĸ��Ӷȡ�
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