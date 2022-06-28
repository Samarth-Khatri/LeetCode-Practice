class Solution {
    public int minDeletions(String s) {
        int []fa = new int[26];
        for(int i=0;i<s.length();++i)
            fa[s.charAt(i)-'a']++;
        Arrays.sort(fa);
        int del=0;
        for(int i=24;i>=0;--i) {
            if(fa[i]==0)
                break;
            while(fa[i]>=fa[i+1] && fa[i]!=0) {
                del++;
                fa[i]--;
            }
        }
        return del;
    }
}