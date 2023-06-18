#include <iostream>
#include <vector>


class Soulution {
/// <summary>
/// ¶¯Ì¬¹æ»®
/// </summary>
public:
	std::string longsetPalindrome(std::string s)
	{
		int n = s.length();
		std::vector<std::vector<bool>> dp(n, std::vector<bool>(n));
		std::string res;
		int begin = 0;
		int max_len = 0;
		for (int L = 1; L <= n; L++)
		{
			for (int i = 0; i < n; i++)
			{
				//L = j+1-i
				int j = L + i - 1;
				if (j >= n)
				{
					break;
				}
				if (s[i] != s[j])
				{
					dp[i][j] = false;
				}
				else {
					dp[i][j] = L <= 2 || dp[i + 1][j - 1];
				}
				if (dp[i][j] && L > max_len)
				{
					begin = i;
					max_len = L;
				}
			}
		}
		return s.substr(begin, max_len);
	}
};