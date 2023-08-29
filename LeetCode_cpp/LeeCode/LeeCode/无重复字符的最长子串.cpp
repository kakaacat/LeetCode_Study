#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

/// <summary>
/// »¬¶¯´°¿Ú
/// </summary>
/// <param name="s"></param>
/// <returns></returns>
int lengthOfSubstring(string s)
{
	if (s.size() == 0) return 0;

	unordered_set<char> set;
	int left = 0;
	int maxStr = 0;

	string res;

	for (int i = 0; i < s.size(); i++)
	{
		while (set.find(s[i]) != set.end())
		{
			set.erase(s[left]);
			left++;
		}

		set.insert(s[i]);
		//maxStr = max(maxStr, i - left + 1);
		if (maxStr < (i - left + 1))
		{
			maxStr = i - left + 1;
			res = s.substr(left, maxStr);
		}
	}

	for (auto c : res)
	{
		cout << c;
	}

	return maxStr;
}


int main()
{
	cout << lengthOfSubstring("abcabcbb") << endl;

	return 0;
}