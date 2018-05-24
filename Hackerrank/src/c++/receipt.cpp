#include<bits/stdc++.h>

using namespace std;

int arr[] = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};


int calc_value(int n) {

		int min_diff = INT_MAX, index = -1;
		for(int i = 0; i<12 ;i++) {
			int diff = n-arr[i];
			if(diff >= 0 && diff < min_diff) {
				min_diff = diff;
				index = i;
			}
		}

    return arr[index];
}

int calc_min(int n) {

		if(n <= 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}

		int nearest_value = calc_value(n);
		cout<<n<<" nerest: "<<nearest_value<<endl;
		return  1 + calc_min(n-nearest_value);

}

int main(){

    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        cout<<calc_min(n);
    }

    return 0;

}


