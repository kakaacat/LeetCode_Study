/*
* 2. �������
�������� �ǿ� ��������ʾ�����Ǹ�������������ÿλ���ֶ��ǰ��� ���� �ķ�ʽ�洢�ģ�����ÿ���ڵ�ֻ�ܴ洢 һλ ���֡�
���㽫��������ӣ�������ͬ��ʽ����һ����ʾ�͵�����
����Լ���������� 0 ֮�⣬���������������� 0 ��ͷ��
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
