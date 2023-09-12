#include <iostream>

using namespace std;

double mypow(double x, long n)
{
	if (n == 1) return x;
	double y = mypow(x, n / 2);
	return (n % 2 == 0 ? y * y : y * y * x);
}

double Pow(double x, int n)
{
	if (x == 1 || n == 0) return 1;
	long ln = n;
	return (n > 0 ? mypow(x, ln) : 1.0 / mypow(x, -ln));
}

int main()
{
	double x = 1.0;
	int n = -2147483646;
	cout << Pow(x, n) << "  " << pow(x, n) << endl;
	return 0;
}