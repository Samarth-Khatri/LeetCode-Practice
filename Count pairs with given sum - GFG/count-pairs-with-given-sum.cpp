// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    int getPairsCount(int arr[], int n, int k) {
        sort(arr,arr+n);
       int low=0,high=n-1,ans=0;
       while(low<high){
           if(arr[low]+arr[high]<k){
               low++;
           }
           else if(arr[low]+arr[high]>k){
               high--;
           }
           else{
               if(arr[low]==arr[high]){
                   int l=high-low+1;
                   ans+=((l*(l-1))/2);
                   break;
               }
               int v1=arr[low],v2=arr[high],c1=0,c2=0;
               while(v1==arr[low]){
                   low++;c1++;
               }
               while(v2==arr[high]){
                   high--;c2++;
               }
               ans+=(c1*c2);
           }
       }
       return ans;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getPairsCount(arr, n, k);
        cout << ans << "\n";
    }
    
    return 0;
}  // } Driver Code Ends