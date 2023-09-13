#include<iostream>

using namespace std;


/*
* 1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���������ֻ����һ�Σ�
* ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨�������ҳ��������ø����洢�ռ�
*/

/// <summary>
/// 1001���������ΪA^A^B 
/// 1-1000�����ΪA^B
/// ����������㽻���ɺͽ���ɣ���X ^ X = 0  0 ^ X = X;
/// ����  (A^ B) ^ (A^ A^ B) = A ^ B ^ B = A
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