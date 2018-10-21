#include<iostream>
#include<string.h>
using namespace std;

template <typename T>
class Node{

public:
    T data;
    Node<T> *next;

    Node(T data){
        this->data = data;
        this->next = NULL;
    }

};

template <typename T>
class Stack{
public:
    Node<T> *head = NULL;
    int capacity = 0;
    //Stack methods needs to now implement

    void _push(T data){
        Node<T> *temp = new Node<T>(data);
        if(head!=NULL){
            temp->next = head;
        }
        head = temp;
        capacity++;
    }

    void _pop(){

        //it just pops and not returns
        Node<T> *temp = head;
        head = head->next;
        temp = NULL;

        capacity--;
    }

    bool isEmpty(){
        if(capacity == 0){
            return true;
        }
        return false;
    }

    T _top(){
        return head->data;
    }


};

int main(){

    ///let's do by implementing stack
    Stack<int> s;
    s._push(1);
    s._push(2);
    s._push(3);
    s._push(4);
    s._pop();
    cout<<"data: "<<s._top()<<endl;


    ///now, brackets balanced question
    cout<<"Enter string: "<<endl;
    string str;
    getline(cin, str);

    Stack<char> st;
    int index = 0, balanced = 1;;
    while(index < str.length()){

        if(str[index] == '{' || str[index] == '(' || str[index] == '['){
                st._push(str[index]);
           }else
           if(str[index] == '}'){
                if(st.isEmpty()){
                    balanced = 0;
                    break;
                }
                char top = st._top();
                if(top != '{'){
                    balanced = 0;
                }else{
                    st._pop();
                }
           }else
           if(str[index] == ']'){
                if(st.isEmpty()){
                    balanced = 0;
                    break;
                }
                char top = st._top();
                if(top != '['){
                    balanced = 0;
                }else{
                    st._pop();
                }
           }else
           if(str[index] == ')'){
                if(st.isEmpty()){
                    balanced = 0;
                    break;
                 }
                char top = st._top();
                if(top != '('){
                    balanced = 0;
                }else{
                    st._pop();
                }
           }
        index++;
    }

    if(balanced == 0){
        cout<<"Not balanced: "<<endl;
    }else{
            cout<<"Balanced"<<endl;
        }

    ///now, just need to implement this


    return 0;
}
