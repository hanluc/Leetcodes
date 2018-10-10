#include <bits/stdc++.h>
using namespace std;

int main()
{
    freopen("in.txt","r",stdin);
    freopen("out.txt","w",stdout);
    vector<string> S;
    ifstream fin;
    fin.open("title.txt");
    string str;
    while (!fin.eof())
    {
        getline(fin, str);
        S.push_back(str);
    }
    fin.close();
    for(int i=0;i<S.size();i++)
    {
        for(int j=S[i].length()-8;j<=S[i].length()-1;j++)
            S[i][j]='\0';
    }
    int n;
    cout<<""<<endl;
    vector<int> index;
    while(scanf("%d",&n)!=EOF)
    {
        index.push_back(n);
    }
    cout<<index.size()<<"questions"<<endl;
    for(int i=0;i<index.size();i++)
        cout<<index[i]<<". "<<S[index[i]-1]<<endl;
    cout<<"https://github.com/hanluc/Leetcodes"<<endl;
    fclose(stdin);
    fclose(stdout);
    system("pause");
    return 0;
}
