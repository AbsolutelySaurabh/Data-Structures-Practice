#include<iostream>
using namespace std;

class Node{

public:
    int data;
    Node *next;

public:
    Node(int data){

        this->data = data;
        this->next = NULL;
    }

};

int main(){

    int n;
    cin>>n;
    Node *head_first = NULL;
    Node *temp_head = head_first;
    while(n!=-1){

        if(head_first == NULL){
            Node *temp = new Node(n);
            head_first = temp;
            temp_head = head_first;
        }else{

            Node *temp = new Node(n);
            temp_head->next = temp;
            temp_head = temp;
        }
        cin>>n;

    }

    Node *head_second = NULL;
    Node *temp_second = head_second;

    int m;
    cin>>m;
    while(m!=-1){

        if(head_second == NULL){
            Node *temp = new Node(m);
            head_second = temp;
            temp_second = head_second;
        }else{

            Node *temp = new Node(m);
            temp_second->next = temp;
            temp_second = temp;
        }
        cin>>m;
    }


    /// Now I've head_first and head_second

    Node *temp_head_first = head_first;
    Node *temp_head_second = head_second;
    while(temp_head_first!=NULL){

        Node *temp = temp_head_first->next;
        temp_head_first->next = temp_head_second;
        temp_head_second = temp_head_second->next;

        temp_head_first->next->next = temp;

        temp_head_first = temp_head_first->next->next;


    }

    ///print the new linkedlist
    while(head_first!=NULL){

        cout<<head_first->data<<endl;
        head_first = head_first->next;
    }


    return 0;
}
