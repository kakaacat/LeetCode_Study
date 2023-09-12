#include <iostream>
#include <string>

using namespace std;

//dp0表示 翻转后第i位是0得次数, 一开始没有翻转初始化为0
//dp1表示 翻转后第i位是0得次数，一开始没有翻转初始化为0
//第i+1位翻转为0, 第i位一定是0，所以第i+1为1则第i位得次数需要 + 1 （如果第i位是1需要加1，是0就不需要翻转了）：dpi+1 = dpi + (i == 1 ? 1 : 0)
//第i+1位翻转为1，第i位可能是0也可能是1，所以第i+1 = 第i位翻转为0与翻转为1得最小值 + 1（如果第i位是0需要加1，是1就不需要翻转了）：dpi+1 = min(dpi) + (i == 0 ? 1 : 0)
//因为dp只用到了第i位和第i+1位，所以只需要两个变量就可以了。
int minFlipsMonoIncr(string s)
{
	int dp0 = 0, dp1 = 0;
	for (char c : s)
	{
		int dpi0 = dp0, dpi1 = min(dp0, dp1);
		//是否需要加1
		if (c == '1')
		{
			dpi0++;
		}
		else
		{
			dpi1++;
		}

		dp0 = dpi0;
		dp1 = dpi1;
	}

	return min(dp0, dp1);
}

int main()
{

	return 0;
}