#include<iostream>
#include<map>
using namespace std;

int main(){

    int n;
    cin>>n;

    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    //int *arr = new arr(n);

    int count=0;
    for(int i=0;i<n-1;i++){
        int odd=0, even=0;
        if(arr[i]%2 == 0){
            even++;
        }else{
            odd++;
        }
        int num = arr[i];
        int new_num;
        for(int j=i+1;j<n;j++){
            if(arr[j]%2==0){
                even++;
            }else{
                odd++;
            }

            if(odd == even){
                count++;
            }
            new_num = num*10 + arr[j];
            num = new_num;

            cout<<num<<endl;
        }
        odd=0, even=0;
    }
    cout<<count<<endl;
    return 0;
}
