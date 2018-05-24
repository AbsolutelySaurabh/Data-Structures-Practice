#include<bits/stdc++.h>
#include "Node.h"
#include "PriorityQueue.h"
#include "InputNode.h"
#include<vector>

using namespace std;

vector<InputNode*> v;

vector<InputNode*> calc_frequencies(string input){

    map<char, int> mp;
    map<char, int>::iterator it;

    for(int i=0;i<input.size();i++){

        if(mp.find(input[i])!=mp.end()){
            mp.insert(pair<char, int>(input[i], mp.find(input[i])->second++ ));
        }else{
            mp.insert(pair<char, int>(input[i], 1));
        }
    }

    //printing frequencies
    //store in vector from map, to make it easy for priority queue
    for(it=mp.begin();it!=mp.end();it++){
        cout<<it->first<<" "<<it->second<<endl;
        InputNode *node = new InputNode(it->first, it->second);
        if(it->first != ' '){
            v.push_back(node);
        }
    }

    //printing vector results
    cout<<"vector data: "<<endl;
    for(int i=0;i<v.size();i++){
        cout<<v[i]->data<<" "<<v[i]->frequency<<endl;
    }
    return v;

}

int main(){

    PriorityQueue<char> pq;

    cout<<"Enter string: "<<endl;
    string str;
    getline(cin, str);

    calc_frequencies(str);

    //building priority queue
    for(int i=0;i<v.size();i++){
        pq.insert(&v[i]->data, v[i]->frequency);
    }

    cout<<pq.getMax()<<" "<<endl;

    return 0;

}


