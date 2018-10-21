#include<bits/stdc++.h>
#include<algorithm>
using namespace std;

int M = 1000000007;

long long int power (long long int a, long long int b) {
    long long int ans=1ll;
    while(b) {
        if(b&1)ans=(ans*a)%M;
        a=(a*a)%M;
        b=b/2;
    }
    return ans;
}

main(){

    long long t;
    cin>>t;
    while(t--){

        unsigned long long n;
        unsigned long long count = 0;

        cin>>n;

        int req_weight;
        cin>>req_weight;

        int k = 10;
        while(k<100) {

				int lsb = k%10;
				int msb = k/10;

				int weight = lsb - msb;
				if(weight == req_weight) {

					count++;
					k+=10;

				}else {
					k++;
				}
        }

        if(n%M>2){

                count = (count%M * power(10, n-2)) % M;
           }

        cout<<count<<endl;
    }
}
