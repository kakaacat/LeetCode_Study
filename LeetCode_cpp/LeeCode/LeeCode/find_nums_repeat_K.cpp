#include <iostream>
#include <vector>
#include <map>

void findRepeatK(std::vector<int> test_array, int k)
{
	std::vector<int> result;
	auto comLambda = [](int a, int b) {return a < b; };
	std::map<int, int, decltype(comLambda)> map(comLambda);
	
	for (int i = 0; i < test_array.size(); i++)
	{
		if (map.count(test_array[i]) > 0)
		{
			map.insert({ test_array[i], map.at(test_array[i])++ });
		}
		else
		{
			map.insert({ test_array[i], 1 });
		}
	}

	for (auto it = map.begin(); it != map.end(); it++)
	{
		if (it->second == k)
		{
			result.push_back(it->first);
		}
	}

	std::cout << "[";
	for (int i = 0; i < result.size(); i++)
	{
		if (i == result.size() - 1)
		{
			std::cout << result[i];
		}
		else
		{
			std::cout << result[i] << ",";
		}
	}
	std::cout << "]" << std::endl;
}

int main()
{
	std::vector<int> test_array1 = { 1, 3, 3, 2, 4, 1, 3, 2, 2, 1, 2 };
	int k1 = 3;
	std::vector<int> test_array2 = { 4, 3, 3, 2, 2, 2, 1 };
	int k2 = 2;
	std::vector<int> test_array3 = { 1, 3, 3, 2, 4, 1, 3, 2, 2, 1, 2, 4, 4};
	int k3 = 3;

	//test1
	findRepeatK(test_array1, k1);
	//test2
	findRepeatK(test_array2, k2);
	//test3
	findRepeatK(test_array3, k3);
	
	return (0);
}