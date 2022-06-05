class Solution {
    public boolean isPowerOfTwo(int n) {
        int ans = 1;
        for(int i=0;i<=30;i++){
            if(ans == n)
                return true;
            if(ans < Integer.MAX_VALUE/2)
            ans*=2;
        }
        return false;
    }
}
// class Solution {
// 	public boolean isPowerOfTwo(int n) {
// 		if(n==1)
//             return true; 
// 		if(n==0)
//             return false; 
// 		if(n%2!=0)
//             return false; 
// 		else
//             return isPowerOfTwo(n/2); 

// 	}
// }