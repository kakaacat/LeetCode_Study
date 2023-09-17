#include <vector>
#include <iostream>
#include <string>


using namespace std;

class NQueueSolution
{
public:
	vector<vector<string>> nQueue(int n)
	{
		result.clear();
		vector<string> chessboard(n, string(n, '.'));
		backtracking(chessboard, n, 0);
		return result;
	}


private:
	/// <summary>
	/// 回溯
	/// </summary>
	/// <param name="chessboard">棋盘</param>
	/// <param name="n">棋盘大小</param>
	/// <param name="row">当前遍历行数</param>
	void backtracking(vector<string>& chessboard, int n, int row)
	{
		//递归出口
		if (row == n)
		{
			result.push_back(chessboard);
			return;
		}

		//遍历同一行
		for (int i = 0; i < n; i++)
		{
			if (isVaild(chessboard, n, row, i))
			{
				chessboard[row][i] = 'Q';			  //合法放置皇后
				backtracking(chessboard, n, row + 1); //下一行
				chessboard[row][i] = '.';			  //回溯
			}
		}
	}

	/// <summary>
	/// 检查同一列，45度，135度是否合法
	/// </summary>
	/// <param name="chessboard"></param>
	/// <param name="n"></param>
	/// <param name="row"></param>
	/// <returns></returns>
	bool isVaild(vector<string>& chessboard, int n, int row, int col)
	{
		//检查同一列是否合法
		for (int i = 0; i < row; i++)
		{
			if (chessboard[i][col] == 'Q') return false;
		}

		//45度
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
		{
			if (chessboard[i][j] == 'Q') return false;
		}

		//135度
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
		{
			if (chessboard[i][j] == 'Q') return false;
		}

		return true;
	}
private:
	vector<vector<string>> result;
};


int main()
{
	NQueueSolution* q(new NQueueSolution());
	vector<vector<string>> res = q->nQueue(4);

	for (int i = 0; i < res.size(); i++)
	{
		for (int j = 0; j < res[i].size(); j++)
		{
			cout << res[i][j];
			cout << "\n";
		}
		cout << "\n";
	}
	return 0;
}