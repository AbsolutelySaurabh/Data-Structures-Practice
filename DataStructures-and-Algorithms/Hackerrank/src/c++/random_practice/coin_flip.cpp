#include<bits/stdc++.h>
using namespace std;

int main(){

	int t;
	cin>>t;
	while(t--){

		int g;
		cin>>g;
		while(g--){

			int initial;
			cin>>initial;
			int n;
			cin>>n;
			int q;
			cin>>q;

			int arr[n];
			for(int i=0;i<n;i++){
				if(initial==1){
					arr[i] = 1;
				}else{
					arr[i] = 2;
				}
			}

			//now,
			for(int i=0;i<n; i++){
				for(int j=0; j<=i; j++){
					if(arr[i] == 1){
						arr[i] = 2;
					}else
					{
						arr[i] = 1;
					}
				}
			}

			//not count q;
			int count_1 = 0, count_2 = 0;
			for(int i=0;i<n; i++){
                if(q == 1 && arr[i] == 1){
                    count_1++;
                }else
                if(q==2 && arr[i]==2){
                    count_2++;
                }
			}
			if(q == 1){
                cout<<count_1<<endl;
			}else{
			    cout<<count_2<<endl;
			}

		}
	}

}
