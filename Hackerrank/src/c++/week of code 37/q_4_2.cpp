#include<bits/stdc++.h>
#include<algorithm>
#include<map>
using namespace std;

class Line{

    public:
    double k, b, x, y;

    public: Line(double k, double b){

        this->k = k;
        this->b = b;

    }

    public: double calc_x(double k, double b, double y){

        double x = (y-b)/k;
        this->x = x;
        return x;
    }

};



int main(){

    int n;
    map<Line*, int> mp;
    cin>>n;
    while(n--){

        string query;
        getline(cin>>ws, query);

        string arr[3];

        long count = 0;
        int index = 0, j = 0;
        string str = "";

        std::vector<std::string> result;
        std::istringstream iss(query);
        for(std::string query; iss >> query; ){
           // mp.insert(pair<Line*, int>(s, 1));
            arr[index] = query;
            index++;
        }

        //cout<<"arr[0]: "<<arr[0]<<endl;
        //cout<<"arr[1]: "<<arr[1]<<endl;
       // cout<<"arr[2]: "<<arr[2]<<endl;

        string sign = arr[0];
        double b;
        double k;
        if(sign!="?"){
                b = stod(arr[2]);
                k = stod(arr[1]);
        }

        if(sign == "+"){
            Line *line = new Line(k, b);
            mp.insert(pair<Line*, int>(line, 1));
        }else
        if(sign == "-"){
            Line *line = new Line(k, b);
            mp.erase(mp.find(line));

        }else
        if(sign == "?"){
            double y = stod(arr[1]);
            //now calculate x for all
            map<Line*, int>::iterator it;
            for(it=mp.begin();it!=mp.end();it++){

                it->first->calc_x(it->first->k, it->first->b, y);

                if(it->first->x - (int)it->first->x == 0){
                    count++;
                }
            }

            cout<<count<<endl;
        }

    }

    return 0;
}
