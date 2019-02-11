#ifndef PQ_NODE_H
#define PQ_NODE_H
//using above is not necessary, but can be to define something initially, to make it compilable.
//refer : http://www.cplusplus.com/doc/tutorial/preprocessor/

template <typename T>
class PqNode{

    public:
        int priority;
        T data;

    public:
        PqNode(T data, int priority){

            this->data = data;
            this->priority = priority;
        }
};

#endif // PQ_NODE_H
