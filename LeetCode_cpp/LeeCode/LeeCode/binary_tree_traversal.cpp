#include <queue>

struct TreeNode
{
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode() : val(0), left(nullptr), right(nullptr) {}
	TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
	TreeNode(int x, TreeNode* left, TreeNode* right) : val(x), left(left), right(right) {}
};

class Solution
{
public:

	/// <summary>
	/// 二叉树的广度优先搜索
	/// </summary>
	/// <param name="root"></param>
	/// <returns></returns>
	std::vector<std::vector<int>> bfs(TreeNode* root)
	{
		std::vector<std::vector<int>> ret;
		if (root == nullptr)
		{
			return (ret);
		}

		std::queue<TreeNode*> q;
		q.push(root);
		while (!q.empty())
		{
			int cur_level_size = q.size();
			std::vector<int> cur_level;
			for (int i = 0; i < cur_level_size; i++)
			{
				auto node = q.front();
				q.pop();
				cur_level.push_back(node->val);
				if (node->left != nullptr)
				{
					q.push(node->left);
				}
				if (node->right != nullptr)
				{
					q.push(node->right);
				}

			}
			ret.push_back(cur_level);
		}
		return (ret);
	}
};