#include <iostream>

using namespace std;

struct ListNode
{
	int value;
	ListNode* next;
	ListNode() :value(0), next(nullptr) {}
	ListNode(int val) :value(val), next(nullptr) {}
	ListNode(int val, ListNode* n) :value(val), next(n) {}
};

/// <summary>
/// �ȼ���������
/// </summary>
/// <param name="head"></param>
/// <param name="n"></param>
/// <returns></returns>
ListNode* removeNthNode(ListNode* head, int n)
{
	int size = 0;
	ListNode* preHead(new ListNode(-1, head));
	ListNode* cur = head;

	while (cur != nullptr)
	{
		size++;
		cur = cur->next;
	}

	cur = preHead;
	for (int i = 0; i < size - n; i++)
	{
		cur = cur->next;
	}

	cur->next = cur->next->next;

	return preHead->next;
}

/// <summary>
/// ˫ָ�� right - left = n,��right������β����leftΪҪɾ���Ľ���ǰһ�����
/// </summary>
/// <param name="head"></param>
/// <param name="n"></param>
/// <returns></returns>
ListNode* removeNthNode2(ListNode* head, int n)
{
	ListNode* preHead(new ListNode(-1, head));

	ListNode* left = preHead;
	ListNode* right = preHead;

	for (int i = 0; i < n; i++)
	{
		right = right->next;
	}

	while (right->next != nullptr)
	{
		right = right->next;
		left = left->next;
	}

	left->next = left->next->next;

	return preHead->next;
}

int main()
{
	ListNode* head(new ListNode(0));
	ListNode* cur = head;
	for (int i = 0; i < 5; i++)
	{
		cur->next = new ListNode(i + 1);
		cur = cur->next;
	}

	cur = head;
	while (cur != nullptr)
	{
		cout << cur->value << " ";
		cur = cur->next;
	}
	cout << endl;

	head = removeNthNode2(head, 2);

	cur = head;
	while (cur != nullptr)
	{
		cout << cur->value << " ";
		cur = cur->next;
	}

	return 0;
}