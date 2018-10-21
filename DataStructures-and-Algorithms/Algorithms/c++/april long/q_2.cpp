#include<bits/stdc++.h>
#include<algorithm>
#include<map>
using namespace std;

int M = 1000000007;

main(){

    // added the two lines below, for fast IO
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;
    cin>>t;
    while(t--){

        long long int n, count = 0;
        map<int, int> mp;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++){
            cin>>arr[i];
            mp.insert(pair<int, int>(arr[i], 0));
        }

        for(int i=0; i<n-1 ;i++){
            for(int j=i+1;j<n;j++){
                long int sum = (arr[i] + arr[j]) % M;

                if(sum%2 == 0){
                    if(mp.find(sum/2)!=mp.end()){
                        count++;
                    }
                }
            }
        }
        cout<<count<<endl;
    }
}
