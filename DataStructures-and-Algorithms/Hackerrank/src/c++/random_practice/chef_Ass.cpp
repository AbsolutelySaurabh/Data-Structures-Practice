#include<bits/stdc++.h>
using namespace std;

int main(){
  int t;
  cin>>t;
  while(t--){

  	int n, m;
  	cin>>n>>m;

  	int completed[m], compl_check[n+1] = {0};
  	for(int i=0;i <m; i++){
  		int c;
  		cin>>c;
  		compl_check[c] = 1;
  	}
  	int chef = 0, ass = 0;
  	vector<int> chef_v, ass_v;
  	for(int i = 1; i<=n; i++){

  		if(compl_check[i] == 0 && chef == 0){

  			chef_v.push_back(i);
  			chef = 1;
  			ass = 0;
  		}else
  		if(compl_check[i] == 0 && ass == 0){

  			ass_v.push_back(i);
  			ass = 1;
  			chef = 0;
  		}

  	}

  	//printing

  	if(chef_v.size() == 0){
        cout<<" ";
  	}else{
        for(int i =0;i <chef_v.size(); i++){
            cout<<chef_v[i]<<" ";
        }
  	}

  	cout<<endl;
  	if(ass_v.size() == 0){
        cout<<" "<<endl;
  	}else{
  	  	for(int i =0;i <ass_v.size(); i++){
            cout<<ass_v[i]<<" ";
        }
  	}

  }

}
