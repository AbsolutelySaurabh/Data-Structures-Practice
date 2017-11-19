#include <iostream>
#include "Node.h"

using namespace std;

main(){

    int n;
    cout<<"Enter the first number: "<<endl;
    cin>>n;
    Node* head = new Node(n);

    /**Both are same**/
    cout<<" (*head): "<<(*head).data<<endl;
    cout<<" head->data:  "<<head->data<<endl;



}
