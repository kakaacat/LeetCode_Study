#include <string>


class Solution
{
public:
	bool backspaceCompare(std::string s, std::string t)
	{
		return (build(s) == build(t));
	}

	std::string build(std::string s)
	{
		std::string ret;
		for (char ch : s)
		{
			if (ch != '#')
			{
				ret.push_back(ch);
			}
			else if (!ret.empty())
			{
				ret.pop_back();
			}
		}
		return (ret);
	}

	/// <summary>
	/// Ë«Ö¸Õë
	/// </summary>
	bool backspaceCompare2(std::string s, std::string t)
	{
		int i = s.length() - 1, j = t.length() - 1;
		int skipS = 0, skipT = 0;
		while (i >= 0 || j >= 0)
		{
			while (i >= 0)
			{
				if (s[i] == '#')
				{
					skipS++, i--;
				}
				else if (skipS > 0)
				{
					skipS--, i--;
				}
				else
				{
					break;
				}
			}

			while (j >= 0)
			{
				if (t[j] == '#')
				{
					skipT++, j--;
				}
				else if (skipT > 0)
				{
					skipT--, j--;
				}
				else
				{
					break;
				}
			}
			if (i >= 0 && j >= 0)
			{
				if (s[i] != t[j])
				{
					return (false);
				}
				
			}
			else 
			{
				if (i >= 0 || j >= 0)
				{
					return (false);
				}
			}
			i--, j--;
		}
		return (true);
	}
}