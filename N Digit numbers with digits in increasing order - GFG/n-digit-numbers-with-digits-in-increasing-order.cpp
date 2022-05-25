// { Driver Code Starts
#include<bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
//User function Template for C++
class Solution
{
public:
    vector<int> increasingNumbers(int n)
    {
        if(n==1) {
            return {0,1,2,3,4,5,6,7,8,9};
        }
        vector<int> vec=increasingNumbers(n-1),ans;
        int lastdigit;
        for(int i=0;i<vec.size();i++) {
            lastdigit=vec[i]%10;
            if(lastdigit==0)
            continue;
            for(int j=lastdigit+1;j<=9;j++) {
                ans.push_back(vec[i]*10+j);
            }
        }
        return ans;
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        int N;
        cin>>N;
        Solution ob;
        vector<int> ans = ob.increasingNumbers(N);
        for(auto num : ans){
            cout<< num <<" ";
        }
        cout<<endl;
        
    }
    return 0;
}  // } Driver Code Ends