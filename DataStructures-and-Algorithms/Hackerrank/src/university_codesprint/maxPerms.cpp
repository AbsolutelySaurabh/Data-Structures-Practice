#include<iostream>
#include<bits/stdc++.h>
#include<iomanip>
using namespace std;

unordered_map<string, int> mp;
int flag = 0;
string max_ans = "";

void findPerms(string str, string output){
    if(str.length()==0){

            //cout<<output<<" ";
            mp.insert(pair<string, int>(output, 0));
			return;
		}
		for(int i=0;i< str.length();i++){
			findPerms((str.substr(0, i) + str.substr(i+1)), output + str[i] );
		}
}

void findSubs(string str) {

    for(int i=0;i<str.length();i++) {
        for(int j=1;j<=str.length() - i;j++) {

            string sub_str = str.substr(i,  j);
            //cout<<sub_str<<"\n";
            if(mp.find(sub_str)!=mp.end()) {
                flag = 1;
                mp[sub_str] ++;
                //cout<<sub_str<<" -> "<<mp[sub_str]<<"\n";

                if(max_ans == "") {
                    max_ans = sub_str;
                }else {
                    if(mp.at(sub_str) > mp.at(max_ans)) {
                        max_ans = sub_str;
                    }else
                        if(mp.at(sub_str) == mp.at(max_ans)) {
                            if(sub_str.compare(max_ans) >= 0) {
                                //get the lexicographically smallest one between the two
                                max_ans = sub_str;
                            }
                        }
                }
            }
        }
    }
}

int main(){

    int t;
    cin>>t;
    while(t > 0){

        string s1, s2;
        cin>>s1>>s2;

        findPerms(s1, "");
        findSubs(s2);

        if(flag == 0){
            cout<<"-1";
        }else{
            if(flag == 1){
                cout<<max_ans;
            }
        }
        mp.clear();
        flag = 0;
        max_ans="";
        t--;
    }
    return 0;
}
