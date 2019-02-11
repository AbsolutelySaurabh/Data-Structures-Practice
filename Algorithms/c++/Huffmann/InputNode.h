#ifndef INPUTNODE_H
#define INPUTNODE_H
#include<bits/stdc++.h>

class InputNode{

    public:
        int frequency;
        char data;

    public:
        InputNode(char data, int frequency){
            this->data = data;
            this->frequency = frequency;
        }

};

#endif // INPUTNODE_H
