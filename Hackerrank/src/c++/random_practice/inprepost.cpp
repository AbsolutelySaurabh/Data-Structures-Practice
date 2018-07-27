#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

//basically, to construct postOrder from given in-pre;
//in array itself

vector<int> arr_post;
int postIndex = 0;
int index = 0;

int search_arr(vector<int> arr, int startIndex, int endIndex, int element){
    if(startIndex > endIndex){
        return -1;
    }

    int mid = (startIndex + endIndex)/2;
    if(arr[mid] == element){
        return mid;
    }
    if(element > arr[mid]){
        return search_arr(arr, mid+1, endIndex, element);
    }
    return search_arr(arr, 0, mid-1, element);
}

void findPost(vector<int> in, vector<int> pre, int start){

    if(in.size() == 1){
        index++;
        arr_post[postIndex] = in[0];
        postIndex++;
    }

    int root = pre[index];
    cout<<"root : "<<root;
    index++;

    int arr_size_in = in.size();
    cout<<"arr size: "<<arr_size_in<<endl;

    int rootIndex = search_arr(in, 0, arr_size_in-1, root);

    cout<<"rootIndex: "<<rootIndex<<" ";

    int left_size = rootIndex-start;
    cout<<"left size: "<<left_size;
    //when found;
    int m = 0;
    vector<int> left_arr;
    for(int i=0;i<left_size; i++){
        left_arr.push_back(in[i]);
        m++;
    }

    int in_size = in.size();
    int right_size = in_size - 1 - rootIndex;
    cout<<"right size: "<<right_size<<" ";

    vector<int> right_arr;
    int k = 0;
    for(int i=rootIndex + 1; i<in_size ; i++){
        right_arr.push_back(in[i]);
        k++;
    }

    findPost(left_arr, pre, start);
    start = rootIndex + 1;
    findPost(right_arr, pre, start);

    arr_post[index] = in[rootIndex];
    postIndex++;

}

int main(){

    int n;
    cin>>n;
    vector<int> pre, in;
    for(int i=0;i<n;i++){
        int m;
        cin>>m;
        in.push_back(m);
    }
    for(int i=0;i<n;i++){
        int m;
        cin>>m;
        pre.push_back(m);
    }

    findPost(in, pre, 0);

    cout<<"printing: ....."<<endl;

    return 0;
}
