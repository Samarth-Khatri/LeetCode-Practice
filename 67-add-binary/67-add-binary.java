class Solution {
    public String addBinary(String a, String b) {
        int c=0, i=a.length()-1, j=b.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0) {
            int sum=c;
            if(i>=0) 
                sum += a.charAt(i)-'0';
            if(j>=0) 
                sum += b.charAt(j)-'0';
            sb.append(sum%2);
            c=sum/2;
            i--; j--;
        }
        if(c>0)
            sb.append(c);

        return sb.reverse().toString();       
    }
}