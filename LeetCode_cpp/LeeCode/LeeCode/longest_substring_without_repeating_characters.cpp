#include <iostream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

/*
* \brief ����һ���ַ��� s �������ҳ����в������ظ��ַ�����Ӵ��ĳ��ȡ�
* \param s �ַ���
*/
int LongestSubstring(string s)
{
	//����set����¼ÿ���ַ��Ƿ���ֹ�
	unordered_set<char> set;

	int rk = -1, ans = 0;

	int n = s.size();

	for (int i = 0; i < n; i++)
	{
		//��ָ������
		if (i != 0)
		{
			set.erase(s[i - 1]);
		}

		while (rk + 1 != n && !set.count(s[rk + 1]))
		{
			set.insert(s[rk + 1]);
			rk++;
		}

		ans = max(ans, rk - i + 1);
	}
	

	return ans;
}

/*
* hashmap �Ż�
*/
int LongestSubstring(string s)
{
	unordered_map<char, int> map;

	int left = -1, ans = 0;

	for (int i = 0; i < s.size(); i++)
	{
		if (map.find(s[i]) == map.end())
		{
			map[s[i]] = i;
			ans = max(ans, i - left + 1);
		}
		else
		{
			left = max(left, map[s[i]] + 1);
			map[s[i]] = i;
			ans = max(ans, i - left + 1);
		}
	}
	return ans;

}