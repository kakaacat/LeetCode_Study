#include <iostream>
#include <unordered_set>


using namespace std;

/// <summary>
/// ����C�����к���rand()�ܹ��������������0-65535�������������30��Ա������齱����ʹ��rand()������дһ�������Ŀ�ִ�г��򣬴���30��Ա���������ȡ10�����н�Ա����
/// ע�⣺Ҫ��֤������ȫ��ȣ�����Ĵ��������١�
/// ˼·��
/// ��300000���ݷֳ�5�飬ÿ��60000�ˣ�Ȼ���ÿ����ѡ��20000����Ϊ���ߡ�
/// �ؼ��������rand()����ʵ��0 - 59999�ȸ��۵�����
/// ������rand()��������0 - 65535֮�������Ȼ����ڵ���60000���������ǣ������õ�����������0 - 59999�У��Ҹ�����ȡ�
/// </summary>
/// <returns></returns>
int main()
{
	unordered_set<int> winner;
	srand(time(NULL));

	//1-60000ѡ20000��
	while (winner.size() < 20000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id);
	}

	//60001-120000ѡ20000
	while (winner.size() < 40000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 60000);
	}

	//120001-180000ѡ20000
	while (winner.size() < 60000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 120000);
	}

	//180001-240000ѡ20000
	while (winner.size() < 80000)
	{
		int rand_id = rand() % 60000 + 1;
		winner.insert(rand_id + 180000);
	}

	//240001-300000ѡ20000
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