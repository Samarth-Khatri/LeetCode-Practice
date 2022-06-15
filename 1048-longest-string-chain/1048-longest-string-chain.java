class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->{
            return a.length()-b.length();
        });
        int omax=0;
        int dp[]=new int[words.length];
        for(int i=0;i<words.length;++i) {
            int max=0;
            for(int j=0;j<i;++j) 
                if(CheckPossible(words[i],words[j]))
                    max=Math.max(max,dp[j]);
            dp[i]=max+1;
            if(omax<dp[i]) 
                omax=dp[i];
        }
        return omax;
     }
    
    public static boolean CheckPossible(String w1,String w2) {
        if(w1.length()!=w2.length()+1) 
            return false;
        int first=0; 
        int second=0;
        while(first<w1.length()) {
            if(second<w2.length() && w1.charAt(first)==w2.charAt(second)){
                first++;
                second++;
            }
            else 
                first++;
        }
        if(first==w1.length() && second==w2.length()) 
            return true;
        else 
            return false;
    }
    
}