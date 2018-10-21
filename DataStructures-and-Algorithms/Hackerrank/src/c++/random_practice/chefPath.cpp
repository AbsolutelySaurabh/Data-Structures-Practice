#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--){

        long long m, n;
        cin>>m>>n;

        if(m == 1 || n == 1){
            if(m == 2 || n == 2){
                cout<<"Yes"<<endl;
            }else{
                cout<<"No"<<endl;
            }
        }else
        if(m%2!=0 && n%2!=0){
            cout<<"No"<<endl;
        }else
        if((m%2 == 0 || n%2 == 0)){
            cout<<"Yes"<<endl;
        }

    }

    return 0;

}
