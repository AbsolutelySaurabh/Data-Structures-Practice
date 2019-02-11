
#include<bits/stdc++.h>
#include<algorithm>
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
    vector<Line*> v;

    cin>>n;
    while(n--){

        string query;
        getline(cin>>ws, query);

        string arr[3];

        int count = 0;
        int index = 0, j = 0;
        string str = "";

        std::vector<std::string> result;
        std::istringstream iss(query);
        for(std::string query; iss >> query; ){
           // mp.insert(pair<Line*, int>(s, 1));
            arr[index] = query;
            index++;
        }

        string sign = arr[0];
        double b;
        double k;
        if(sign!="?"){
                b = stod(arr[2]);
                k = stod(arr[1]);
        }

        if(sign == "+"){
            Line *line = new Line(k, b);
            //double x = line->calc_x(k, b, 4);
            v.push_back(line);
        }else
        if(sign == "-"){
            Line *line = new Line(k, b);

            for(int i=0;i<v.size();i++){
                if(v[i]->k == k && v[i]->b == b){
                    v.erase(v.begin() + i);
                }
            }

        }else
        if(sign == "?"){
            double y = stod(arr[1]);
            for(int i=0;i<v.size();i++){

                v[i]->calc_x(v[i]->k, v[i]->b, y);
                if(v[i]->x - (int)v[i]->x == 0){
                    count++;
                }
            }

            cout<<count<<endl;
        }

    }

    return 0;
}
