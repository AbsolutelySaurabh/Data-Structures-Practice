#include<bits/stdc++.h>
using namespace std;
main(){

    int n;
    cin>>n;
    int winner = 0, player = 0;
    int max = INT_MIN, one = 0, two = 0;
    while(n--){

        int a, b;
        int diff = 0;
        cin>>a>>b;

        one+=a;
        two+=b;

        if(one > two){
            diff = one-two;
            winner = 1;
        }else
            if(one < two){
                diff = two-one;
                winner = 2;
            }
        if(diff > max){
            player = winner;
            max = diff;
        }

    }

    cout<<player<<" "<<max;

}
