#include<bits/stdc++.h>
using namespace std;

int binarySearch(vector<long long> v, int start, int end, long long element){

    if(start > end){
        return -1;
    }

    int mid = (start + end)/2;
    if(v[mid] == element){
        return mid;
    }

    if(element > v[mid]){
        return binarySearch(v, mid+1, end, element);
    }
    return binarySearch(v, 0, mid-1, element);
}

int main(){

	int t;
	cin>>t;
	while(t--){

		int n;
		cin>>n;
		vector<long long> v;
		long long val;
		for(int i=0; i <n; i++){
			cin>>val;
			v.push_back(val);
		}
		int uncle_pos;
		cin>>uncle_pos;

		long long pos_val = v[uncle_pos-1];

		sort(v.begin(), v.end());

		int final_pos = binarySearch(v, 0, v.size()-1, pos_val);
		cout<<final_pos+1<<endl;
	}


}
