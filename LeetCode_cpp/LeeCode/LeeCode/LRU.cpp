#include <list>
#include <unordered_map>
class LRUCache
{
public:
	LRUCache(int capacity) :
		size_(capacity) //初始化size大小
	{}
	
	int get(int key)
	{
		if (map_.find(key) == map_.end())
		{
			return -1; //如果key值不存在,直接返回-1
		}
		else
		{
			list_.splice(list_.begin(), list_, map_[key]);	//key存在需更新key对应的缓存到list的头部
			return map_[key]->second;
		}
	}

	void put(int key, int value)
	{
		if (get(key) != -1)
		{
			//key存在,调用get时已将缓存移到头部，再更新map
			map_[key]->second = value;
		}
		else
		{
			//缓存是否满了,删除最久未使用数据，map中也要删
			if (list_.size() == size_)
			{
				int del_key = list_.back().first;
				list_.pop_back();
				map_.erase(del_key);
			}
			list_.emplace_front(key, value); //如果key不存在，在头部加入新的缓存
			map_[key] = list_.begin();
		}
	}
private:
	int size_;
	std::list<std::pair<int, int>> list_; //数据用双向链表保存
	std::unordered_map<int, std::list<std::pair<int, int>>::iterator> map_;//value值是list的迭代器形式
};