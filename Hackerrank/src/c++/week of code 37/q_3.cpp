#include<bits/stdc++.h>
#include<map>
#include<string>
using namespace std;

map<string, int> mp;
map<string, int>:: iterator it;
void calc_permus(string, string);

void calc_permus(string input, string output){

    if(input.size()==0){
                cout<<"output: "<<output<<endl;
                mp.insert(pair<string, int>(output, 1));
                return;
            }
    for(int i=0;i< input.size();i++){
        calc_permus((input.substr(0, i) + input.substr(i+1)), output + input[i] );
    }
}

int main(){

    int t;
    cin>>t;

    while(t--){

        int A[26];
        string str="";
        for(int i=0;i<26;i++){
            cin>>A[i];
            for(int j=0;j<A[i];j++){
                char e = i +'a';
                str =  str + e;
            }
        }

        cout<<"str: "<<str<<endl;

        //not alc_all permutations();
        calc_permus(str, "");

        for(it = mp.begin();it!=mp.end();it++){
            cout<<"---"<<it->first<<endl;
        }

    }

    return 0;
}

