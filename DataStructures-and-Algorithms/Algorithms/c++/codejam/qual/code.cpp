#include<bits/stdc++.h>
#include<algorithm>
#include<map>
using namespace std;

map<string, int> mp;
string original_str;

int calc_hacks(string A, string B){
    int swaps = 0;
    for(int i=0;i<A.size();i++){
        if(A[i]!=B[i]){
            swaps++;
        }
    }

    if((swaps%2 == 0)){
        return swaps/2;
    }
    return (swaps/2) + 1;
}

int CC_present(string str, int index){
    if(index == str.size()){
        return false;
    }
    if(str[index] == 'C'){
        return true;
    }
    return CC_present(str, ++index);
}

int SS_present(string str, int index){
    if(index == str.size()){
        return false;
    }
    if(str[index] == 'S'){
        return true;
    }
    return SS_present(str, ++index);
}

int calc_damage_first(string str, int damage){

    int charge = damage;
    int count_damage = 0;

    //check for CC and SS=>OMPOSSIBLE
    //CC=> 0
    if(!CC_present(str, 0)){
        return -1;
    }else
    if(!SS_present(str, 0)){
        return 0;
    }

    for(int i=0;i<str.size();i++){

        if(str[i] == 'S'){
            damage = charge;
            count_damage += damage;
        }

        if(str[i] == 'C'){
           charge*=2;
        }
    }
    return count_damage;
}

int calc_damage(string str, int damage){

    int charge = damage;
    int count_damage = 0;

    for(int i=0;i<str.size();i++){

        if(str[i] == 'S'){
            damage = charge;
            count_damage += damage;
        }

        if(str[i] == 'C'){
           charge*=2;
        }
    }
    return count_damage;
}

int min_damage = INT_MAX, hacks;
void permutationsHelper(string input, string output){
    if(input.size()== 0){
        //cout<<"original_str: "<<original_str<<" "<<"output: "<<output<<" ";

        //calculate the damage
        int damage_created = calc_damage(output, 1);
        //cout<<"damage created: "<<damage_created<<" ";

        if(damage_created < min_damage){

            min_damage = damage_created;
            hacks = calc_hacks(output, original_str);

            cout<<"min_damage: "<<min_damage<<" output: "<<output<<" hacks: "<<hacks<<endl;
        }

        //cout<<"min_damage till: "<<min_damage<<" ";

        //calculate the hacks needed
        //int hacks = calc_hacks(output, original_str);
        //cout<<"hacks: "<<hacks<<endl;
        //mp.insert(pair<string, int>(output, hacks));

        return;
    }
    for(int i=0;i<input.size();i++){
       permutationsHelper((input.substr(0, i) + input.substr(i+1)), output + input[i] );
    }
}

main(){

    int test;
    cin>>test;
    while(test--){

        int max_damage;
        cin>>max_damage;

        string str;
        cin>>str;
        original_str = str;

        //first calculate the damage_Creates
        int count_damage = calc_damage_first(str, 1);
        //cout<<"count_damage: "<<count_damage<<" ";

        if(count_damage == 0 || count_damage<0 || count_damage<max_damage){
            //case 'SS'
            if(count_damage < 0){
                cout<<"count_damage: "<<"IMPOSSIBLE"<<endl;
            }else
            if(count_damage == 0 || count_damage < max_damage){
                cout<<"count_damage: "<<count_damage<<endl;
            }
        }
        if(count_damage > max_damage){
            permutationsHelper(str, "");
            cout<<"hacks: "<<hacks<<" "<<"min_damage: "<<min_damage<<endl;
        }
        hacks = 0;
        min_damage = INT_MAX;
    }
}
