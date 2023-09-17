#include <iostream>
#include <stack>
#include <unordered_map>
#include <string>

using namespace std;

class Solution
{
public:
	bool isValid(string s)
	{
		stack<char> stk;
		unordered_map<char, char> map = {
			{')', '('},
			{']', '['},
			{'}', '{'}
		};
		for (char c : s)
		{
			if (map.count(c) != 0)
			{
				if (stk.empty() || stk.top() != map[c])
				{
					return false;
				}
				stk.pop();
			}
			else
			{
				stk.push(c);
			}
			
		}

		return (stk.empty());
	}
	
	
	
	/*bool isValid(string s)
	{
		stack<char> stk;

		for (char c : s)
		{
			if (c == '(' || c == '[' || c == '{')
			{
				stk.push(c);
			}
			if(stk.empty()) return false;
			char temp = stk.top();
			stk.pop();

			if (temp != '(' && c == ')' || temp != '[' && c == ']' || temp != '{' && c == '}')
			{
				return false;
			}
		}

		return (stk.empty());
	}*/
};