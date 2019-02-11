#include<iostream>
#include<queue>
#include<stack>
using namespace std;

int main(){

    priority_queue<int> pq;
    pq.push(1);
    pq.push(1);
    pq.push(1);
    pq.push(3);
    pq.push(1);
    pq.push(1);
    pq.push(2);

    cout<<pq.top();
    pq.pop();
    cout<<pq.top();
    return 0;
}
