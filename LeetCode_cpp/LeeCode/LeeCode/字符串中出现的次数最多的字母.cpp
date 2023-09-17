#include <iostream>
#include <unordered_map>

using namespace std;

int main()
{
	string s;
	cin >> s;

	unordered_map<char, int> map;

	for (char c : s)
	{
		map[c]++;
	}

	int max = 0;
	char max_c = '\0';

	for (const auto& pair : map)
	{
		if (max < pair.second)
		{
			max = pair.second;
			max_c = pair.first;
		}
	}

	cout << max_c << " : " << max;

	return 0;
}