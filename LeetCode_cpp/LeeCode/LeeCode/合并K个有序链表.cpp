#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct ListNode
{
	int value;
	ListNode* next;
	ListNode() {}
	ListNode(int val) : value(val), next(nullptr) {}
	ListNode(int val, ListNode* n) : value(val), next(n) {}
};

ListNode* mergeTwo(ListNode* l1, ListNode* l2)
{
	if (l1 == nullptr || l2 == nullptr) return (l1 == nullptr ? l2 : l1);

	ListNode* preHead(new ListNode(-1, nullptr));

	ListNode* pre = preHead;

	while (l1 != nullptr && l2 != nullptr)
	{
		if (l1->value < l2->value)
		{
			pre->next = l1;
			l1 = l1->next;
		}
		else
		{
			pre->next = l2;
			l2 = l2->next;
		}

		pre = pre->next;
	}

	pre->next = l1 == nullptr ? l2 : l1;

	return preHead->next;
}

ListNode* mergeKLists(vector<ListNode*>& lists)
{
	ListNode* res = nullptr;
	for (int i = 0; i < lists.size(); i++)
	{
		res = mergeTwo(res, lists[i]);
	}

	return res;
}

/// <summary>
/// 分治
/// </summary>
/// <param name="lists"></param>
/// <returns></returns>
ListNode* merge(vector<ListNode*>& lists, int l, int r)
{
	if (l == r) return lists[l];
	if (l > r) return nullptr;
	int mid = (r - l) / 2;	// >>1
	return mergeTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
}

ListNode* mergeKLists2(vector<ListNode*>& lists)
{
	return merge(lists, 0, lists.size() - 1);
}


/// <summary>
/// 优先队列
/// </summary>
/// <returns></returns>
ListNode* mergeKLists3(vector<ListNode*>& lists)
{
	auto cmp = [](const ListNode* a, const ListNode* b) {
		return a->value > b->value;
	};

	priority_queue < ListNode*, vector<ListNode*>, decltype(cmp) >queue;

	for (ListNode* head : lists)
	{
		if (head != nullptr) queue.push(head);
	}

	ListNode* preHead(new ListNode(-1));
	ListNode* cur = preHead;

	while (!queue.empty())
	{
		ListNode* node = queue.top();
		queue.pop();
		
		if (node->next != nullptr)
		{
			queue.push(node->next);
		}
		cur->next = node;
		cur = cur->next;
	}

	return preHead->next;
}


int main()
{
	return 0;
}