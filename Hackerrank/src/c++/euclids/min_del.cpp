#include<bits/stdc++.h>
#include<array>
using namespace std;

bool isPrime(int n)
{
    // Corner cases
    if (n <= 1)  return false;
    if (n <= 3)  return true;

    // This is checked so that we can skip
    // middle five numbers in below loop
    if (n%2 == 0 || n%3 == 0) return false;

    for (int i=5; i*i<=n; i=i+6)
        if (n%i == 0 || n%(i+2) == 0)
           return false;

    return true;
}

int main(){

    int t;
    cin>>t;

    while(t--){

        int n, is_prime_present = 0, is_divided = 0, one_present = 0;
        cin>>n;
        int arr[n], first;
        for(int i=0;i<n;i++){
            cin>>arr[i];
            if(i == 0){
                first == arr[0];
            }
            if(is_prime_present == 0){
                if((arr[i] == 2 || arr[i] == 3) && i!=0){
                    if(isPrime(arr[i])){
                      is_prime_present = 1;
                    }
                }

            }

            if(arr[i] == 1){
                one_present = 1;
            }

            if(i > 0 && is_divided == 0){
                if(arr[i]%first == 0 && arr[i]!=1 && first!=1){
                    is_divided = 1;
                }else{
                   is_divided = 0;
                }
            }
        }

        if(one_present == 1 || is_prime_present ){
            cout<<"0"<<endl;
        }

        if(is_divided == 1){
            cout<<"-1"<<endl;
        }


    }

    return 0;
}
