#include <iostream>
#include <string>
#include <cassert>
#include <stdexcept>

using namespace std;


class String
{
public:
	typedef char* iterator;

	String();	//默认构造
	String(const char* s);	//S拷贝构造
	String(const String& s);
	//String(const String&& s); //C++11 移动拷贝构造
	String& operator=(const char* s);	//赋值构造
	String& operator=(const String& s);
	//String& operator=(const String&& s); //C++11 移动赋值构造
	~String();

	const size_t size() const { return len_; };

	char& operator[](int i);
	String& operator+(const char* s);
	char& at(int i);

	bool empty();

	iterator begin();
	iterator end();

	char& front();
	char& back();

private:
	size_t len_;
	char* str_;
};

String::String()
{
	len_ = 2;
	str_ = new char[1];
	str_[0] = '\0';
}

String::String(const char* s)
{
	len_ = strlen(s);
	str_ = new char[len_ + 1];
	strcpy(str_, s);
}

String::String(const String& s)
{
	len_ = s.size();
	str_ = new char[len_ + 1];
	strcpy(str_, s.str_);
}

String& String::operator=(const char* s)
{
	delete[] str_;
	len_ = strlen(s);
	str_ = new char[len_ + 1];
	strcpy(str_, s);

	return *this;
}

String& String::operator=(const String& s)
{
	if (this == &s) return *this;
	delete[] str_;
	len_ = s.size();
	str_ = new char[len_ + 1];
	strcpy(str_, s.str_);

	return *this;
}

String::~String()
{
	len_ = 0;
	delete[] str_;
}

char& String::operator[](int i)
{
	return str_[i];
}

String& String::operator+(const char* s)
{
	strcat(str_, s);
	return *this;
}

char& String::at(int i)
{
	if (i < 0 || i >= len_) throw out_of_range("out_of_range");
	return str_[i];
}

bool String::empty()
{
	return (len_ == 0);
}

String::iterator String::begin()
{
	return str_;
}

String::iterator String::end()
{
	return str_ + len_;
}

char& String::front()
{
	assert(empty());
	return *begin();
}

char& String::back()
{
	assert(empty());
	return *(end() - 1);
}

