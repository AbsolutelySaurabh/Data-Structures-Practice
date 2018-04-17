#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin>>n;

    int arr[n], count = 0;
    double sum = 0;
    for(int i=0;i<n;i++){
        cin>>arr[i];
        if(arr[i] >= 90){
            sum+=arr[i];
            count++;
        }
    }
    double ans = sum/count;

    double rounded_val = (int)(ans*100 + 0.5);
    double rounded = rounded_val/100;

    cout<<fixed<<setprecision(2)<<rounded<<endl;
    return 0;
}

