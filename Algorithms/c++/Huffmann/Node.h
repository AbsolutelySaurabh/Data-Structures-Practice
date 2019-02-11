#ifndef NODE_H
#define NODE_H
//using above is not neccessary, but can be to define something initially, to make it compilable.
//refer : http://www.cplusplus.com/doc/tutorial/preprocessor/

#include<bits/stdc++.h>
using namespace std;

#define M 8
typedef bitset<M> BYTE;

class Node{

    public:
        BYTE value;
        int frequency;
        Node *leftChild;
        Node *rightChild;

    Node(int value, int frequency){

        this->value = value;
        leftChild = rightChild = NULL;
        this->frequency = frequency;
    }
};
#endif
