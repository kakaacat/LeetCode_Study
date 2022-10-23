#include <iostream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

/*
* \brief 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
* \param s 字符串
*/
int LongestSubstring(string s)
{
	//集合set，记录每个字符是否出现过
	unordered_set<char> set;

	int rk = -1, ans = 0;

	int n = s.size();

	for (int i = 0; i < n; i++)
	{
		//左指针右移
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
* hashmap 优化
*/
int LongestSubstring2(string s)
{
	unordered_map<char, int> map;

	int left = 0, ans = 0;

	for (int i = 0; i < s.size(); i++)
	{
		//不存在就插入
		//map[]  查找或插入
		if (!map.count(s[i]))
		{
			map[s[i]] = i;
			ans = max(ans, i - left + 1);
		}
		//存在就跟新位置并且移动左指针
		else
		{
			left = max(left, map[s[i]] + 1);
			map[s[i]] = i;
			ans = max(ans, i - left + 1);
		}
	}
	return ans;

}