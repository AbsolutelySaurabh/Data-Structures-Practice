#include<bits/stdc++.h>
using namespace std;

long long calc_gcd(long long a, long long b){

    if(a == 0){
        return b;
    }else
    if( b == 0){
        return a;
    }
    return calc_gcd(b%a, a);
}

int main(){

    long long n;
    cin>>n;
    long long arr[n];
    for(long long i=0;i<n;i++){
        cin>>arr[i];
    }

    long long num_q;
    cin>>num_q;

    while(num_q--){

        long long count = 0;

        long long type, x, y, l, r, g;
        cin>>type;

        if(type == 1){
            cin>>x>>y;
            arr[x-1] = y;
        }else
        if(type == 2){
            cin>>l>>r>>g;

            for(int i = l-1; i<r; i++){

                if(g == 1 || arr[i] == 1){
                    count++;
                }else
                if(arr[i] % g != 0){
                     if(calc_gcd(g, arr[i]) == 1){
                       count++;
                     }
                }
            }
            cout<<count<<endl;
        }
    }

    return 0;
}
