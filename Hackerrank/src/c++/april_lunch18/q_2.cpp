#include<bits/stdc++.h>
#include<algorithm>
using namespace std;

string func(int arr[], int n, int k, int arr0_flag){

    if(arr[0] == 1){
        return "YES";
    }

    if(arr0_flag == 0){
        return "NO";
    }

    if(k >= arr[0]){
        return "YES";
    }

    //check the case when arr[0] > k, but arr0_flag == 1
    if(arr[0] > k){

        if(arr0_flag == 1){
            int flag;
            for(int i=k; k>= 2; k--){
                flag = 1;
                if(arr[0] % i == 0){
                    //check for others too
                    for(int j = 1; j<n ;j++){
                        if(arr[j] % i != 0){
                            flag = 0;
                            break;
                        }

                    }
                }

                if(flag == 1){
                    return "YES";
                }
            }

        }
    }
    return "NO";

}

int main(){

    int t;
    cin>>t;
    while(t--){

        int n, k;
        cin>>n>>k;
        int arr[n], arr0_flag = 0;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(arr0_flag == 0){
                if(arr[i]%arr[0] != 0){
                    arr0_flag = 1;
                }
            }

        }
        sort(arr, arr+n);

        cout<<func(arr, n, k, arr0_flag)<<endl;

    }

    return 0;
}
