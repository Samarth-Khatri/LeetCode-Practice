class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String []ss = s.split(" ");
        for(int i=0;i<ss.length;++i) {
            sb.append(new StringBuilder(ss[i]).reverse());
            if(i != ss.length-1) sb.append(" ");
        }
        return sb.toString();
    }
}