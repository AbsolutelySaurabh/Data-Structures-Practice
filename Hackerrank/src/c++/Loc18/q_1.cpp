#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin>>n;
    int max_r = INT_MIN, max_w = INT_MIN, r_flag = 0, w_flag = 0;
    while(n--){

        int r, w;
        cin>>r>>w;

        if(r<max_r){
            r_flag = 1;
        }
        max_r = r;
        if(w == 10 && max_w == 10){
            w_flag = 1;
        }
        if(w < max_w){
            w_flag = 1;
        }
        max_w = w;
    }

    if(r_flag == 1 || w_flag == 1){
        cout<<"NO"<<endl;
    }else{
        cout<<"YES"<<endl;
    }

    return 0;
}
