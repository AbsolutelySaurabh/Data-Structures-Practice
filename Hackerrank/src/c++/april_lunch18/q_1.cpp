#include<bits/stdc++.h>
using namespace std;

int func(int n){

    if(n%10 == 0){
        return 0;
    }

    if(n%5 == 0){
        return 1;
    }

    return -1;
}

int main(){

    int t;
    cin>>t;
    while(t--){

        int n;
        cin>>n;
        cout<<func(n)<<endl;

    }
    return 0;
}
