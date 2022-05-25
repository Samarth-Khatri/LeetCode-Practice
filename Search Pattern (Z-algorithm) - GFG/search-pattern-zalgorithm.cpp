// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
         vector <int> search(string pat, string txt)
       {
           int i, lengthOfpat = pat.length(),lengthOftxt = txt.length();
           vector<int> output;
           bool flag=false;
           for(i=0;i<=lengthOftxt-lengthOfpat;i++)
           {
               if(txt.compare(i,lengthOfpat,pat)==0)
               {
               output.push_back(i+1);
               flag=true;
                   
               }
           }
           
           if(flag)
           return output;
           else
           {
               output.push_back(-1);
               return output;
           }
       }
     
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string S, pat;
        cin >> S >> pat;
        Solution ob;
        vector <int> res = ob.search(pat, S);
        if(res.size()==0)
            cout<<"-1 ";
        else
            for (int i : res)
                cout << i << " ";
        cout << endl;
    }
    return 0;
}

  // } Driver Code Ends