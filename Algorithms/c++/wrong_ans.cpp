#include<iostream>
using namespace std;
main(){

    int a, b;
    cin>>a>>b;

    if(a%10 == 0){

        if(b == 1){
            cout<<(a-b-2)<<endl;
        }else{
            cout<<(a-b-1)<<endl;
        }
    }

    if(a%9 == 0){

        if(b == 1){
            cout<<(a-b-2)<<endl;
        }else{
            cout<<(a-b-1)<<endl;
        }
    }

    if(a%10 >= 1){
        if(b == 1){
            cout<<(a-b+2)<<endl;
        }else{
            cout<<(a-b-1)<<endl;
        }
    }

}
