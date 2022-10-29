#include <list>
#include <unordered_map>
class LRUCache
{
public:
	LRUCache(int capacity) :
		size_(capacity) //��ʼ��size��С
	{}
	
	int get(int key)
	{
		if (map_.find(key) == map_.end())
		{
			return -1; //���keyֵ������,ֱ�ӷ���-1
		}
		else
		{
			list_.splice(list_.begin(), list_, map_[key]);	//key���������key��Ӧ�Ļ��浽list��ͷ��
			return map_[key]->second;
		}
	}

	void put(int key, int value)
	{
		if (get(key) != -1)
		{
			//key����,����getʱ�ѽ������Ƶ�ͷ�����ٸ���map
			map_[key]->second = value;
		}
		else
		{
			//�����Ƿ�����,ɾ�����δʹ�����ݣ�map��ҲҪɾ
			if (list_.size() == size_)
			{
				int del_key = list_.back().first;
				list_.pop_back();
				map_.erase(del_key);
			}
			list_.emplace_front(key, value); //���key�����ڣ���ͷ�������µĻ���
			map_[key] = list_.begin();
		}
	}
private:
	int size_;
	std::list<std::pair<int, int>> list_; //������˫��������
	std::unordered_map<int, std::list<std::pair<int, int>>::iterator> map_;//valueֵ��list�ĵ�������ʽ
};