#include<iostream>
using namespace std;
main(){

    int t;
    cin>>t;
    while(t--){

        int n;
        cin>>n;
        int sum = 0;
        while(n>0){
            sum+=n%10;
            n/=10;
        }
        cout<<sum<<endl;
    }
}
