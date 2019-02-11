#include<iostream>
#include<iomanip>
using namespace std;

int main(){

    int withdraw;
    cin>>withdraw;
    double cash;
    cin>>cash;
    double charge = 0.50;

    if(withdraw > 0 && withdraw<=2000){
        if((withdraw + charge) <= cash){
            if(withdraw%5 == 0){
                cash = cash - withdraw;
                cash = cash-0.5;
            }
        }
    }
    cout<<setprecision(2)<<fixed<<cash<<endl;

    return 0;
}
