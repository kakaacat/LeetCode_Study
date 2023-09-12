#include <iostream>
#include <string>

using namespace std;

//dp0��ʾ ��ת���iλ��0�ô���, һ��ʼû�з�ת��ʼ��Ϊ0
//dp1��ʾ ��ת���iλ��0�ô�����һ��ʼû�з�ת��ʼ��Ϊ0
//��i+1λ��תΪ0, ��iλһ����0�����Ե�i+1Ϊ1���iλ�ô�����Ҫ + 1 �������iλ��1��Ҫ��1����0�Ͳ���Ҫ��ת�ˣ���dpi+1 = dpi + (i == 1 ? 1 : 0)
//��i+1λ��תΪ1����iλ������0Ҳ������1�����Ե�i+1 = ��iλ��תΪ0�뷭תΪ1����Сֵ + 1�������iλ��0��Ҫ��1����1�Ͳ���Ҫ��ת�ˣ���dpi+1 = min(dpi) + (i == 0 ? 1 : 0)
//��Ϊdpֻ�õ��˵�iλ�͵�i+1λ������ֻ��Ҫ���������Ϳ����ˡ�
int minFlipsMonoIncr(string s)
{
	int dp0 = 0, dp1 = 0;
	for (char c : s)
	{
		int dpi0 = dp0, dpi1 = min(dp0, dp1);
		//�Ƿ���Ҫ��1
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