#include<bits/stdc++.h>
#include "PqNode.h"

using namespace std;
template <typename T>
class priority_queue{

    public:
        vector<PqNode<T*>*> v;

    private: void getLeftChildIndex(int index){
        return 2*index + 1;
    }

    private: void getRightChildIndex(int index){
        return 2*index + 2;
    }

    private: void getParentIndex(int index){
        return (index-1)/2;
    }

    private: void swap(int index, int maxIndex){
        PqNode<T*> temp = v[index];
        v[index] = v[maxIndex];
        v[maxIndex] = temp;
    }

    private: void max_heapify(int index){

        int arr_size = v.size();
        while(index < arr_size){

            int maxIndex = index;
            if(v[getRightChildIndex(index)] > v[maxIndex]){
                maxIndex = getRightChildIndex(index);
            }

            if(v[getLeftChildIndex(index)] > v[maxIndex]){
                maxIndex = getLeftChildIndex(index);
            }

            if(maxIndex == index){
                return;
            }

            swap(index, maxIndex);
            index = maxIndex;
        }

    }

    public: PqNode<T*> getMax(){
        return v[0];
    }

    public: void popMax(){
        PqNode<T*> popped = v.remove(0);
        max_heapify(0);
        cout<<"removed: data: "<<popped.data<<" priority: "<<popped.priority<<endl;
        return popped;
    }

    public: void insert(T* data, int priority){

        v.push_back(new PqNode<T*>(data, priority));
        //run max_heaoify after insertion
        max_heapify(0);
    }

};
