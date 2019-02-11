#include <bits/stdc++.h>
using namespace std;

int main(){

    long long n;
    cin>>n;

    long long max = 0;

    string arr1[n];
    long long arr2[n];

    for(int i=0;i<n;i++){
        cin>>arr1[i];

        cin>>arr2[i];

        if(arr1[i] == "set"){
            if(arr2[i] > max){
                max = arr2[i];
            }
        }else
        if(arr1[i] == "add"){
            if(max + arr2[i] > max){
                max += arr2[i];
            }
        }
    }

    cout<<max<<endl;
    return 0;
}
