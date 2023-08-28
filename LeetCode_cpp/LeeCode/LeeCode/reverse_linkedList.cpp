/**
* 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
**/
#include <iostream>

struct ListNode {
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}
};

/**
* \brief 迭代
* \param[in] head：链表头结点指针
*/
ListNode* reverseList(ListNode* head)
{
	ListNode* prev = nullptr;
	ListNode* curr = head;
	while (curr != nullptr)
	{
		ListNode* next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
	}
	return curr;
}

/**
* \brief 递归
* \param[in] head：链表头结点指针
*/
ListNode* reverseList2(ListNode* head)
{
	if (head == nullptr || head->next == nullptr)
	{
		return head;
	}
	ListNode* newHead = reverseList2(head->next);
	head->next->next = head;
	head->next = nullptr;
	return newHead;
}

