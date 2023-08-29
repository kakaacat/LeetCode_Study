/*
* 2. 两数相加
给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
*/

#include <iostream>

struct ListNode
{
	int value;
	ListNode* next;
	ListNode() : value(0), next(nullptr) {}
	ListNode(int val) : value(val), next(nullptr) {}
	ListNode(int val, ListNode* n) : value(val), next(n) {}
};


ListNode* add(ListNode* l1, ListNode* l2)
{
	int flag = 0;

	ListNode* preHead(new ListNode(-1));
	ListNode* cur = preHead;

	while (l1 != nullptr || l2 != nullptr || flag != 0)
	{
		int n1 = l1 == nullptr ? 0 : l1->value;
		int n2 = l2 == nullptr ? 0 : l2->value;

		//if (l1 != nullptr) flag += l1->value;
		//if (l2 != nullptr) flag += l2->value;

		int tempVal = n1 + n2 + flag;	
		cur->next = new ListNode(tempVal % 10);	//flag % 10
		cur = cur->next;
		flag = tempVal / 10;
		//flag /= 10;

		if (l1 != nullptr) l1 = l1->next;
		if (l2 != nullptr) l2 = l2->next;
	}

	return preHead->next;
}

int main()
{
	
}
