#include<bits/stdc++.h>
#include<math.h>
using namespace std;
int main(){

    int i = 0, n = 7, m = 7;
    int arr1[7], arr2[7];
    while(n--){
        cin>>arr1[i];
        i++;
    }

    i = 0;
    while(m--){
        cin>>arr2[i];
        i++;
    }

    int sum = 0;
    for(int i=0;i<7;i++){

        sum+= abs(arr1[i] - arr2[i]);
    }
    cout<<sum<<endl;

    return 0;
}
