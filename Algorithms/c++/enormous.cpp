#include<iostream>
using namespace std;

int main(){

    int n, k;
    long long num;
    int count = 0;
    cin>>n>>k;
    while(n--){
        cin>>num;
        if(num%k == 0){
            count++;
        }
    }
    cout<<count<<endl;
    return 0;
}
