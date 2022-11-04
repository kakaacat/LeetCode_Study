#include <iostream>

struct ListNode {
	int val;
	ListNode* next;
	ListNode() : val(0), next(nullptr) {}
	ListNode(int x) : val(x), next(nullptr) {}
	ListNode(int x, ListNode* next) : val(x), next(next) {}
};

class ReverseNodes
{
public:
	// 翻转一个子链表，并且返回新的头与尾
	std::pair<ListNode*, ListNode*> reverse(ListNode* head, ListNode* tail)
	{
		ListNode* prev = tail->next;
		ListNode* p = head;
		while (prev != tail)
		{
			ListNode* next = p->next;
			p->next = prev;
			prev = p;
			p = next;
		}
		
		return { tail, head };
	}

	ListNode* reverseKGroup(ListNode* head, int k)
	{
		ListNode* temp_head = new ListNode(0);
		temp_head->next = head;
		ListNode* prev = temp_head;

		while (head != nullptr)
		{
			ListNode* tail = prev;
			for (int i = 0; i < k; i++)
			{
				tail = tail->next;
				if (tail == nullptr)
				{
					return temp_head->next;
				}
			}
			ListNode* next = tail->next;

			std::pair<ListNode*, ListNode*> result = reverse(head, tail);
			
			prev->next = result.first;
			result.second->next = next;
			prev = result.second;
			head = next;
		}

		return temp_head->next;
	}

};