#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

//int findMaxLength(vector<int>& nums, int k) {
//    unordered_map<int, int> sumCount;
//    int maxLength = 0;
//    int currSum = 0;
//
//    // ��ʼ��ǰ׺��Ϊ0�ļ���Ϊ1�����ڴ������������ƽ��������k�����
//    sumCount[0] = 1;
//
//    for (int i = 0; i < nums.size(); i++) {
//        currSum += nums[i];
//
//        // ���㵱ǰǰ׺����Ŀ��ƽ�����Ĳ�ֵ
//        int diff = currSum - k;
//
//        // �����ֵ������֮ǰ��ǰ׺���У���˵���ҵ���һ��ƽ��������k��������
//        if (sumCount.count(diff)) {
//            maxLength = max(maxLength, i + 1 - sumCount[diff]);
//        }
//
//        // �����ǰǰ׺�Ͳ�������map�У�������ӽ�ȥ
//        if (!sumCount.count(currSum)) {
//            sumCount[currSum] = i + 1;
//        }
//    }
//
//    return maxLength;
//}
//
//int main() {
//    int n, k;
//    cout << "����������������ĳ���n��Ŀ��ƽ����k��" << endl;
//    cin >> n >> k;
//
//    vector<int> nums(n);
//    cout << "������" << n << "����������" << endl;
//    for (int i = 0; i < n; i++) {
//        cin >> nums[i];
//    }
//
//    int result = findMaxLength(nums, k);
//    cout << "ƽ�������õ���" << k << "�������������ĳ���Ϊ��" << result << endl;
//
//    return 0;
//}


class A
{
public:
	A() { std::cout << "a"; }
	~A() { std::cout << "b"; }
	A(const A&) { std::cout << "c"; }
	A& operator=(const A&) { std::cout << "d"; return *this; }
};

void main()
{
	A a;
	auto f = [=]() { A b = a; };
	f();
}
