﻿#include <iostream>

using namespace std;

/// <summary>
/// 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。

/// 函数 myAtoi(string s) 的算法如下：

/// 读入字符串并丢弃无用的前导空格
/// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
/// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
/// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
/// 如果整数数超过 32 位有符号整数范围[−231, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
/// 返回整数作为最终结果。
/// </summary>
class Solution
{
public:
	int atoi(string s)
	{
		/*stringstream liu(s);
		int n = 0;
		liu >> n;
		return n;*/

		if (s.empty())
		{
			return 0;
		}

		int index = 0;
		int n = s.size(), sign = 1, res = 0;

		//处理前置空格
		while (index < n && s[index] == ' ')
		{
			index++;
		}

		//处理符号
		if (index < n && s[index] == '+' || s[index] == '-')
		{
			sign = s[index++] == '+' ? 1 : -1;
		}

		//处理数字
		while (index < n && isdigit(s[index]))
		{
			int digit = s[index] - '0';
			//判断是否溢出
			if (res > (INT_MAX - digit) / 10)
			{
				return sign == 1 ? INT_MAX : INT_MIN;
			}

			res = res * 10 + digit;
			index++;
		}

		return res * sign;
	}
};