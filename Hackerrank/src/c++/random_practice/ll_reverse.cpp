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

Node* reverse_ll(Node *head, Node *prev, Node *adv){
    if(adv == NULL){
        Node *new_head = prev;
        return new_head;
    }


    Node *new_head = reverse_ll(head, prev->next, prev->next->next);

    adv->next = prev;
    prev->next = NULL;

    return new_head;

}

int main(){


    int n;
    cin>>n;
    Node *head = NULL;
    Node *temp_head = head;
    while(n!=-1){

        if(head == NULL){
            Node *temp = new Node(n);
            head = temp;
            temp_head = head;
        }else{

            Node *temp = new Node(n);
            temp_head->next = temp;
            temp_head = temp;
        }
        cin>>n;

    }


    Node *new_head = reverse_ll(head, head, head->next);

    while(new_head!=NULL){
        cout<<new_head->data<<endl;
        new_head = new_head->next;
    }

    return 0;
}
