#include <iostream>
#include <forward_list>
#include <vector>
#include <set>


struct ListNode
{
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}
};


void removeItem(std::forward_list<int>& list, std::vector<int> index)
{
	std::set<int> index_set(index.begin(), index.end());
	
	std::forward_list<int> temp_list;
	int i = 1;
	for (auto it = list.begin(); it != list.end(); it++)
	{
		if (index_set.count(i++) == 0)
		{
			temp_list.emplace_front(*it);
		}
	}
	list.clear();
	for(auto i : temp_list)
	{
		list.emplace_front(i);
	}
}

int main()
{
	std::cout << "test 1 " << std::endl;
	std::forward_list<int> test_list1({1,2,3,4,5,6,7,8,9});
	std::vector<int> indices1({ 3,6,8 });
	removeItem(test_list1, indices1);

	for (auto i : test_list1)
	{
		std::cout << i << " " << std::endl;
	}
	std::cout << "test 2 " << std::endl;
	std::forward_list<int> test_list2({10,20,30,40,50});
	std::vector<int> indices2({ 4,2 });
	removeItem(test_list2, indices2);

	for (auto i : test_list2)
	{
		std::cout << i << " " << std::endl;
	}

	return (0);
}