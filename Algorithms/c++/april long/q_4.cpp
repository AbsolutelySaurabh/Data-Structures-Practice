#include<bits/stdc++.h>
#include<algorithm>
#include<string>
#include<map>
using namespace std;

map<string, int> mp;
map<string, int>::iterator it;
long long count_a = 0, count_b = 0, a_count = 0;

void subString(string input, string output){

    if(input.size() == 0){
        mp.insert(pair<string, int>(output, 1));
        return;
    }

    subString(input.substr(1) , output + input[0]);
    mp.insert(pair<string, int>(output, 1));

}

void count_a_b(string str){

    for(int i=0;i<str.size();i++){
        if(str[i] == 'a'){
            count_a++;
        }else
        if(str[i] == 'b'){
            count_b++;
        }
    }
}

int main(){

    int t;
    cin>>t;
    while(t--){

        string str;
        cin>>str;

        long long n;
        cin>>n;

        subString(str);

        for(it = mp.begin();it!=mp.end();it++){
            count_a_b(it->first);
            if(count_a > count_b){
                a_count++;
            }
            count_a = 0, count_b = 0;
        }

        int num = n;
        if(a_count!=0){

            while(num > 0){

            }
        }

        cout<<a_count<<endl;

        a_count = 0, count_a = 0, count_b = 0;
    }
    return 0;
}
