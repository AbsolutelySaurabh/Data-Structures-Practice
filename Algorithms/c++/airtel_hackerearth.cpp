#include<iostream>
#include<map>
using namespace std;

int main(){

    int n;
    cin>>n;

    int arr[n];
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    map<int, int> mp;

    int count=0;
    for(int i=0;i<n-1;i++){
        int odd=0, even=0;
        if(arr[i]%2 == 0){
            even++;
        }else{
            odd++;
        }
        int num = arr[i];
        int new_num;
        for(int j=i+1;j<n;j++){

            new_num = num*10 + arr[j];
            num = new_num;

            if(mp.find(num)!=mp.end()){
                if(mp.find(num)->second == 1){
                    count++;
                    cout<<mp.find(num)->first<<" It is found"<<endl;
                }
            }else{

                if(arr[j]%2==0){
                    even++;
                }else{
                    odd++;
                    }

                if(odd == even){
                    count++;
                //1 means odd==even
                    mp.insert(pair<int, int>(num, 1));

                }else{
                    mp.insert(pair<int, int>(num, 0));
                }

            }

        }
        odd=0, even=0;
    }
    cout<<count<<endl;
    return 0;
}
