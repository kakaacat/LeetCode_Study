#include <iostream>

using namespace std;

struct ListNode
{
	int value;
	ListNode* next;
	ListNode() {}
	ListNode(int val) : value(val), next(nullptr) {}
	ListNode(int val, ListNode* n) : value(val), next(n) {}
};

/// <summary>
/// µÝ¹é
/// </summary>
/// <param name="l1"></param>
/// <param name="l2"></param>
/// <returns></returns>
ListNode* merge(ListNode* l1, ListNode* l2)
{
	//ListNode* preHead = new ListNode(-1, nullptr);
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

//µü´ú
ListNode* merge2(ListNode* l1, ListNode* l2)
{
	if (l1 == nullptr)
	{
		return l2;
	}
	if (l2 == nullptr)
	{
		return l1;
	}

	if (l1->value < l2->value)
	{
		l1->next = merge2(l1->next, l2);
		return l1;
	}
	else
	{
		l2->next = merge2(l1, l2->next);
		return l2;
	}
}

int main()
{

}