#include<bits/stdc++.h>
using namespace std;

int main(){

    int n;
    cin>>n;
    int c[n];
    int type[n];

    for(int i=0;i<n;i++){
        cin>>c[i];
    }

    int min_t = INT_MAX, min_t_index = 0;
    int min_a = INT_MAX, min_a_index = 0;
    int min_both = INT_MAX, min_both_index = 0;
    for(int i=0;i<n;i++){

        cin>>type[i];
        if(type[i] == 1){
            if(c[i] < min_t){
                min_t = c[i];
                min_t_index = i;
            }
        }else
            if(type[i] == 2){
                if(c[i] < min_a){
                    min_a = c[i];
                    min_a_index = i;
                }
            }else
            if(type[i] == 3){
                if(c[i] < min_both){
                    min_both = c[i];
                    min_both_index = i;
                }
            }
    }

    //now compare
    if(c[min_both_index] < c[min_a_index] + c[min_t_index]){
        cout<<c[min_both_index]<<endl;
    }else{
        cout<<c[min_t_index] + c[min_a_index]<<endl;
    }
}
