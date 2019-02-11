#include<bits/stdc++.h>
#include<algorithm>
#include<map>
using namespace std;

main(){

    int t;
    cin>>t;
    while(t--){

        int n, count = 0;
        map<int, int> mp;
        map<int, int>:: iterator it;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(mp.find(arr[i]) == mp.end()){
               mp.insert(pair<int, int>(arr[i], 1));

            }else{

               mp.insert(pair<int, int>(arr[i], mp.find(arr[i])->second++));
               cout<<"arr[i]: "<<arr[i]<<" "<<"-> "<<mp.find(arr[i])->second<<endl;

            }
        }

        for(int i=0; i<n-1 ;i++){
            if(mp.find(arr[i])-> second != 0){

                for(int j=i+1;j<n;j++){
                    int sum = arr[i] + arr[j];

                    if(sum%2 == 0){
                        if(mp.find(sum/2)!=mp.end()){
                            it = mp.find(sum/2);
                            it->second = 0;
                            count++;
                        }

                    }
                }
            }else{
                count++;
            }
        }
        cout<<count<<endl;
    }
}
