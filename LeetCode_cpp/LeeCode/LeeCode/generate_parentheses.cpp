//生成括号：数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
#include <iostream>
#include <vector>

class Solution
{
public:
	/// <summary>
	/// 动态规划
	/// 简单来说，在求N个括号的排列组合时，把第N种情况（也就是N个括号排列组合）视为单独拿一个括号E出来，
	/// 剩下的N-1个括号分为两部分，P个括号和Q个括号，P+Q=N-1，然后这两部分分别处于括号E内和括号E的右边，各自进行括号的排列组合。
	/// 由于我们是一步步计算得到N个括号的情况的，所以小于等于N-1个括号的排列组合方式我们是已知的（用合适的数据结构存储，方便后续调用，
	/// 且在存储时可利用特定数据结构实现题目某些要求，如排序，去重等），且P+Q=N-1，P和Q是小于等于N-1的，所以我们能直接得到P个和Q个括号的情况，进而得到N个括号的结果
	/// </summary>
	/// <param name="n"></param>
	/// <returns></returns>
	std::vector<std::string> generateParenthesis(int n)
	{
		if (n == 0)
		{
			return {};
		}
		if (n == 1)
		{
			return { "()" };
		}
		std::vector<std::vector<std::string>> dp(n + 1);
		dp[0] = { "" };
		dp[1] = { "()" };

		for (int i = 2; i <= n; i++)
		{
			for (int j = 0; j < i; j++)
			{
				for (std::string p : dp[j])
				{
					for (std::string q : dp[i - j - 1])
					{
						std::string str = "(" + p + ")" + q;
						dp[i].push_back(str);
					}
				}
			}
		}
		return dp[n];
	}

	/*
	* 回溯法
	* 
	*/
	std::vector<std::string> generate(int n)
	{
		std::vector<std::string> result;
		std::string current;
		backtrack(result, current, 0, 0, n);
		return result;
	}

private:
	void backtrack(std::vector<std::string>& ans, std::string& cur,
		int open, int close, int n) {
		if (cur.size() == n * 2)	//n对括号
		{
			ans.push_back(cur);
			return;
		}
		if (open < n)	//可以添加左括号	1对括号一个（
		{
			cur.push_back('(');
			backtrack(ans, cur, open + 1, close, n);
			cur.pop_back();		//回溯
		}
		if (close < open)	//可以添加右括号
		{
			cur.push_back(')');
			backtrack(ans, cur, open, close + 1, n);
			cur.pop_back();
		}
	}
};
