class Solution {
    public String reverseWords(String s) {
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=sArr.length-1;i>=0;--i) 
            if (!sArr[i].equals("")) {
                sb.append(" ");
                sb.append(sArr[i]);
            }
        return sb.substring(1).toString();
    }
}