#include<bits/stdc++.h>
using namespace std;

main(){

    int n, index = 0;
    cin>>n;
    int arr[n];
    while(index<n){

        cin>>arr[index];
        index++;
    }
    sort(arr, arr + n);

    for(int i=0;i<n;i++){
        cout<<arr[i]<<endl;
    }
}
