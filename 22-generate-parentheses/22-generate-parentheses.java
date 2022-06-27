class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        rres("",n,n,res);
        return res;
    }
    void rres(String str, int open, int close, List<String> ans){
        if(open==0 && close==0)
            ans.add(str);
        
        if(open!=0)
            rres(str+"(",open-1,close,ans);
        
        if(open<close)
            rres(str+")",open,close-1,ans);
        
    }
}