#include<bits/stdc++.h>
using namespace std;

#define M 1000000007
int main(){

    int t;
    cin>>t;
    while(t--){

        long long n, k, ans = 1;
        cin>>n>>k;
        for(long long i=0; i<n-1; i++){
            ans = (ans%M * (k-1)%M)%M;
        }
        cout<<((ans%M)*(k%M))%M<<endl;

    }
    return 0;
}
