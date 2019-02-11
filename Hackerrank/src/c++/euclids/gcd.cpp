#include<bits/stdc++.h>
using namespace std;

int calc_gcd(int a, int b){

    if(a == 0){
        return b;
    }
    return calc_gcd(b%a, a);
}

int calc_gcd_arr(int arr[], int startIndex, int endIndex){

    if(startIndex == endIndex){
        return arr[endIndex];
    }

    int first = arr[startIndex];
    return calc_gcd(first, calc_gcd_arr(arr, ++startIndex, endIndex ));

}

int calc_gcd_three_numbers(int a, int b, int c){

    return calc_gcd(a, calc_gcd(b, c));
}

int main(){

    cout<<"Enter two numbers: "<<endl;
    int a, b;
    cin>>a>>b;
    //gcd of a, b  = b, a same
    cout<<endl<<"gcd of a = "<<a<<" b = "<<b<<" is: "<<calc_gcd(a, b);


    cout<<endl<<"Enter three numbers: "<<endl;
    int c, d, e;
    cin>>c>>d>>e;
    //gcd of a, b  = b, a same
    cout<<endl<<"gcd of c = "<<c<<" d = "<<d<<" e = "<<e<<" is: "<<calc_gcd_three_numbers(c, d, e);

    //now gcd for array
    int n;
    cout<<endl<<"Enter n: "<<endl;
    cin>>n;
    int arr[n];
    cout<<"Enter n elements: "<<endl;
    for(int i=0;i<n;i++){
        cin>>arr[i];
    }

    cout<<endl<<"size of arr: "<<sizeof(arr)/sizeof(arr[0])<<endl;

    cout<<"gcd of array is: "<<calc_gcd_arr(arr, 0, n);

    return 0;
}
