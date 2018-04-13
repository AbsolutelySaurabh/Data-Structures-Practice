#include<bits/stdc++.h>
#include<algorithm>
using namespace std;

int M = 1000000007;

long long int calc_power(int num, int n){

    if(n==0){
        return 1;
    }

    if(n == 1){
        return num;
    }
    return (10*calc_power(num, --n)) % M;
}

main(){

    long long t;
    cin>>t;
    while(t--){

       // unsigned long long int n;
        long long count = 0;
        //cin>>n;

        string str;
        long long int a,s,c;
        cin>>str;
        c=str.size();
        long long int arr[c];
        s=0;
        int h = c;
        unsigned long long int number = 0;
        while(s!=c)
        {
            number = (number%M + ((str[s]-'0')*calc_power(10, h-1))%M )%M;
            h--;
            s++;
        }

        cout<<"number "<<number<<endl;

        int req_weight;
        cin>>req_weight;

        int k=10;
        while(k<100){

            int lsb = k%10;
            int msb = k/10;

            int weight = lsb-msb;
            if(weight == req_weight){
                count++;
                k+=10;
            }else{
                k++;
            }
        }

        if(number>2){
                count = (count*calc_power(10, number-2)) % M;
            }

        cout<<count<<endl;
    }
}
