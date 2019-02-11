#include<iostream>
#include<algorithm>
#include<array>
using namespace std;

vector<int> form_wave(vector<int> arr){

    if(arr.size() == 0){
        return {0};
    }
    sort(arr.begin(), arr.end());
    for(int i=0;i<arr.size()-1;i++){
        swap(arr[i], arr[i+1]);
        i++;
    }
    return arr;
}

int main(){

    int n;
    cin>>n;
    vector<int> arr(n);
    int i=0;
    while(i!=n){
        cin>>arr[i];
        i++;
    }

    vector<int> new_arr = form_wave(arr);

    //print
    for(int i=0;i<new_arr.size();i++){
        cout<<new_arr[i]<<" ";
    }

    return 0;
}
