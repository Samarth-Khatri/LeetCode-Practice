class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        if(n==2)
            return "11";
        
        String s = "11";
        for(int i=3;i<=n;++i) {
            s+='0';
            int len = s.length();
            String temp="";
            int cnt=1;
            for(int j=1;j<len;++j) {
                if(s.charAt(j)!=s.charAt(j-1)) {
                    temp += cnt;
                    temp += s.charAt(j-1);
                    cnt=1;
                }
                else
                    cnt++;
            }
            s=temp;
        }
        
        return s;
    }
}