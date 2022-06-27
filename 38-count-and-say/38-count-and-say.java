class Solution {        
  public String countAndSay(int n) {
      if(n==1) 
          return "1";
      if(n==2) 
          return "11";
      String str="11";
      for (int i=3;i<=n;++i) {
          int cnt=1;
          str+="a";   // count till 2nd last char
          String res="";
          char[] array = str.toCharArray();
          for(int j=1;j<array.length;++j) {
              if(array[j]!=array[j-1]) {
                  res += cnt;
                  res += array[j-1];
                  cnt=1;
              }
              else
                  cnt++;
          }
          str=res;            
      }
      return str;
  }
}