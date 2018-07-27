#include<bits/stdc++.h>
using namespace std;

int main(){

    int t;
    cin>>t;
    while(t--){

        int n;
        cin>>n;

        string room_seq;
        cin>>room_seq;

        int count_r = 0, count_g = 0, count_b = 0, m = 0;

        for(int i=0;i<n;i++){
            if(room_seq[i] == 'R'){
                count_r++;
            }else
            if(room_seq[i] == 'G'){
                count_g++;
            }else
            if(room_seq[i] == 'B'){
                count_b++;
            }
            if(count_r >= m){
                m = count_r;
            }
            if(count_g >= m){
                m = count_g;
            }

            if(count_b >= m){
                m = count_b;
            }
        }

        int ans = 0;
        if(count_r == n || count_g == n || count_b == n){
            ans = 0;
        }else
        if(count_r == count_g && count_g == count_b){
            ans = n - count_r;
        }else{
            ans = n-m;
        }
        cout<<ans<<endl;
    }

    return 0;
}
