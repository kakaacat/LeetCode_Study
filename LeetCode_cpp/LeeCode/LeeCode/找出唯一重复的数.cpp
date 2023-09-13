#include<iostream>

using namespace std;


/*
* 1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，其它均只出现一次．
* 每个数组元素只能访问一次，设计一个算法，将它找出来；不用辅助存储空间
*/

/// <summary>
/// 1001个数异或结果为A^A^B 
/// 1-1000异或结果为A^B
/// 由于异或满足交换律和结合律，且X ^ X = 0  0 ^ X = X;
/// 则有  (A^ B) ^ (A^ A^ B) = A ^ B ^ B = A
/// </summary>
/// <returns></returns>
int main()
{
	int a[1001];
	for (int i = 0; i < 1001; i++) a[i] = i+1;
	a[1000] = 5;

	for (int i : a)
	{
		cout << i << " ";
	}

	int res = 0;
	for (int i = 0; i < 1001; i++)
	{
		res = res ^ a[i];
	}

	for (int i = 1; i < 1001; i++)
	{
		res = res ^ i;
	}


	cout << res;
	return 0;
}