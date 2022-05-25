// { Driver Code Starts
 
#include<bits/stdc++.h>
using namespace std; 

 // } Driver Code Ends
  
class Solution{ 
public:
  string onesComplement(string S,int N){
       string ans="";
       for(int i=0;i<S.length();i++){
           if(S[i]=='0'){
               ans+="1";
           }
           else{
               ans+="0";
           }
       }
       return ans;
   }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n;
        cin>>n;
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.onesComplement(s,n)<<"\n";
    }
}  // } Driver Code Ends