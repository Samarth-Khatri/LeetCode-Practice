class Solution {
    public int maxNumberOfBalloons(String text) {
        
        char[] arr = new char[26];
        int res = 0;
        boolean flag = true;
        
        for (char ch : text.toCharArray()) 
            arr[ch-'a']++;
        
        while(flag) {
            for(char ch : "balloon".toCharArray()) 
                if(arr[ch-'a']--<=0) 
                    return res;
            res++;
        }
        
        return res;
    }
}