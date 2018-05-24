#include<bits/stdc++.h>
#include "PqNode.h"

template <typename T>
class PriorityQueue{

    public:
        vector<PqNode<T*>*> v;

    private: int getLeftChildIndex(int index){
        return 2*index + 1;
    }

    private: int getRightChildIndex(int index){
        return 2*index + 2;
    }

    private: int getParentIndex(int index){
        return (index-1)/2;
    }

    private: bool hasLeftChild(int index){
        int flag = false;
        if(getLeftChildIndex(index) < v.size()){
            flag = true;
        }
        return flag;
    }

    private: bool hasRightChild(int index){
        int flag = false;
        if(getRightChildIndex(index) < v.size()){
            flag = true;
        }
        return flag;
    }

    private: bool hasParentChild(int index){
        return true;
    }

    private: void swap(int index, int maxIndex){
        PqNode<T*> *temp = v[index];
        v[index] = v[maxIndex];
        v[maxIndex] = temp;
    }

    private: void max_heapify(int index){

        int arr_size = v.size();
        //need to go from down to up, for max heapify
        int floor = 0;
        if((arr_size)%2 == 0){
            floor = (arr_size)/2 - 1;
        }else{
            floor = (arr_size)/2 -1;
        }
        while(floor >= 0){

            int maxIndex = floor;
            PqNode<T*> *parent = v[maxIndex];

            if(hasLeftChild(floor)){
                PqNode<T*> *leftChild = v[getLeftChildIndex(floor)];
                if(leftChild !=NULL && parent!=NULL){

                    if(leftChild->priority > v[maxIndex]->priority){
                        maxIndex = getLeftChildIndex(floor);
                    }
                }
            }

            if(hasRightChild(floor)){
                PqNode<T*> *rightChild = v[getRightChildIndex(floor)];
                if(rightChild != NULL && parent!=NULL){

                    if(rightChild->priority > v[maxIndex]->priority){
                        maxIndex = getRightChildIndex(floor);
                    }
               }
            }

            swap(floor, maxIndex);
            floor--;

        }

    }

    public: T getMax(){
        //here, v[0]->data returns char*, which is of pointer type, hence need to dereference it.
        return *(v[0]->data);
    }

    public: void popMax(){
        PqNode<T*> popped = v.remove(0);
        max_heapify(0);
        cout<<"removed: data: "<<popped.data<<" priority: "<<popped.priority<<endl;
        return popped;
    }

    public: void insert(T* data, int priority){

        v.push_back(new PqNode<T*>(data, priority));
        //run max_heapify after insertion
        max_heapify(0);
        cout<<"after heapify max: "<<endl;
        for(int i=0;i<v.size();i++){
            cout<<"data: "<<v[i]->data<<" priority: "<<v[i]->priority<<endl;
        }
    }

};
