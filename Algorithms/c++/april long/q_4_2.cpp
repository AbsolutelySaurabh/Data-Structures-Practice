#include<bits/stdc++.h>
#include<algorithm>
#include<string>
using namespace std;

long long count_a = 0, count_b = 0, a_count = 0;

void _count_a_b(string str){
    for(int i = 0;i<str.size();i++){
        if(str[i] == 'a'){
            count_a++;
        }else
        if(str[i] == 'b'){
            count_b++;
        }
    }
}

void subString(string input, string output){

    if(input.size() == 0){

        _count_a_b(output);
        if(count_a > count_b){
            a_count++;
        }
        count_a = 0, count_b = 0;
        return;
    }

    subString(input.substr(1) , output + input[0]);
    _count_a_b(output);
        if(count_a > count_b){
            a_count++;
        }
    count_a = 0, count_b = 0;
}

int main(){

    int t;
    cin>>t;
    while(t--){

        string str;
        string o_str;
        cin>>str;

        o_str = str;
        long long n;
        cin>>n;
        while(n>1){
            str+=o_str;
            n--;
        }

        subString(str, "");

        cout<<a_count<<endl;
        count_a = 0, count_b = 0, a_count = 0;
    }
    return 0;
}
