//�������ţ����� n �����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
#include <iostream>
#include <vector>

class Solution
{
public:
	/// <summary>
	/// ��̬�滮
	/// ����˵������N�����ŵ��������ʱ���ѵ�N�������Ҳ����N������������ϣ���Ϊ������һ������E������
	/// ʣ�µ�N-1�����ŷ�Ϊ�����֣�P�����ź�Q�����ţ�P+Q=N-1��Ȼ���������ֱַ�������E�ں�����E���ұߣ����Խ������ŵ�������ϡ�
	/// ����������һ��������õ�N�����ŵ�����ģ�����С�ڵ���N-1�����ŵ�������Ϸ�ʽ��������֪�ģ��ú��ʵ����ݽṹ�洢������������ã�
	/// ���ڴ洢ʱ�������ض����ݽṹʵ����ĿĳЩҪ��������ȥ�صȣ�����P+Q=N-1��P��Q��С�ڵ���N-1�ģ�����������ֱ�ӵõ�P����Q�����ŵ�����������õ�N�����ŵĽ��
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
	* ���ݷ�
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
		if (cur.size() == n * 2)	//n������
		{
			ans.push_back(cur);
			return;
		}
		if (open < n)	//�������������	1������һ����
		{
			cur.push_back('(');
			backtrack(ans, cur, open + 1, close, n);
			cur.pop_back();		//����
		}
		if (close < open)	//�������������
		{
			cur.push_back(')');
			backtrack(ans, cur, open, close + 1, n);
			cur.pop_back();
		}
	}
};
