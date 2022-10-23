#include <amp.h>
#include <iostream>

int main()
{

	std::vector<int> v(5);
	for (int i = 0; i < 5; i++)
	{
		v[i] = i + 10;
	}
	concurrency::array<int, 1> a(5, v.begin(), v.end());

	concurrency::parallel_for_each(a.extent,
		[&a](concurrency::index<1> idx) restrict(amp)
		{
			a[idx] = a[idx] * 10;
		});

	v = a;
	for (int i = 0; i < 5; i++)
	{
		std::cout << v[i] << "\n";
	}
}