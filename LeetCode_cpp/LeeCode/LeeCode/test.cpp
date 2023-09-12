#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

//int findMaxLength(vector<int>& nums, int k) {
//    unordered_map<int, int> sumCount;
//    int maxLength = 0;
//    int currSum = 0;
//
//    // 初始化前缀和为0的计数为1，用于处理整个数组的平均数等于k的情况
//    sumCount[0] = 1;
//
//    for (int i = 0; i < nums.size(); i++) {
//        currSum += nums[i];
//
//        // 计算当前前缀和与目标平均数的差值
//        int diff = currSum - k;
//
//        // 如果差值存在于之前的前缀和中，则说明找到了一个平均数等于k的子数组
//        if (sumCount.count(diff)) {
//            maxLength = max(maxLength, i + 1 - sumCount[diff]);
//        }
//
//        // 如果当前前缀和不存在于map中，则将其添加进去
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
//    cout << "请输入正整数数组的长度n和目标平均数k：" << endl;
//    cin >> n >> k;
//
//    vector<int> nums(n);
//    cout << "请输入" << n << "个正整数：" << endl;
//    for (int i = 0; i < n; i++) {
//        cin >> nums[i];
//    }
//
//    int result = findMaxLength(nums, k);
//    cout << "平均数正好等于" << k << "的最长连续子数组的长度为：" << result << endl;
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
