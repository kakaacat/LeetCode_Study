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
	/// ����
	/// </summary>
	/// <param name="chessboard">����</param>
	/// <param name="n">���̴�С</param>
	/// <param name="row">��ǰ��������</param>
	void backtracking(vector<string>& chessboard, int n, int row)
	{
		//�ݹ����
		if (row == n)
		{
			result.push_back(chessboard);
			return;
		}

		//����ͬһ��
		for (int i = 0; i < n; i++)
		{
			if (isVaild(chessboard, n, row, i))
			{
				chessboard[row][i] = 'Q';			  //�Ϸ����ûʺ�
				backtracking(chessboard, n, row + 1); //��һ��
				chessboard[row][i] = '.';			  //����
			}
		}
	}

	/// <summary>
	/// ���ͬһ�У�45�ȣ�135���Ƿ�Ϸ�
	/// </summary>
	/// <param name="chessboard"></param>
	/// <param name="n"></param>
	/// <param name="row"></param>
	/// <returns></returns>
	bool isVaild(vector<string>& chessboard, int n, int row, int col)
	{
		//���ͬһ���Ƿ�Ϸ�
		for (int i = 0; i < row; i++)
		{
			if (chessboard[i][col] == 'Q') return false;
		}

		//45��
		for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
		{
			if (chessboard[i][j] == 'Q') return false;
		}

		//135��
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