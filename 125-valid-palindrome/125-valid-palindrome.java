class Solution {
    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i = 0; 
        int j = str.length()-1;        
        while(i<j) {
            char front = str.charAt(i);
            char back = str.charAt(j);
            while(!Character.isLetterOrDigit(front) && i<j) {
                 i++; 
                 front = str.charAt(i);   
            }
                    
            while(!Character.isLetterOrDigit(back) && i<j) {
                j--;
                back = str.charAt(j);
            }  
            
         
            if(front != back)
               return false;
            
            i++;
            j--;
        }
        
        return true;
    }
}