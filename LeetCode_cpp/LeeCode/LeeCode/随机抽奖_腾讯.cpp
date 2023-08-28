#include <iostream>
#include <unordered_set>


using namespace std;

/// <summary>
/// 假设C库中有函数rand()能够生产均匀随机地0-65535的随机数，现有30万员工参与抽奖，请使用rand()函数编写一个完整的可执行程序，从这30万员工中随机抽取10万名中奖员工。
/// 注意：要保证概率完全相等，运算的次数尽量少。
/// 思路：
/// 将300000数据分成5组，每组60000人，然后从每组中选出20000人作为获奖者。
/// 关键是如何用rand()函数实现0 - 59999等概论的数。
/// 可以用rand()函数生成0 - 65535之间的数，然后大于等于60000的数不考虑，这样得到的数都是在0 - 59999中，且概率相等。
/// </summary>
/// <returns></returns>
int main()
{
	unordered_set<int> winner;
	srand(time(NULL));

	//1-60000选20000人
	while (winner.size() < 20000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id);
	}

	//60001-120000选20000
	while (winner.size() < 40000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 60000);
	}

	//120001-180000选20000
	while (winner.size() < 60000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 120000);
	}

	//180001-240000选20000
	while (winner.size() < 80000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 180000);
	}

	//240001-300000选20000
	while (winner.size() < 100000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 240000);
	}
	
	for (const auto& id : winner)
	{
		cout << id << " " << endl;
	}

	return 0;
}