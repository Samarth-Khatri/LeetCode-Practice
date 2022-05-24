class Solution {
public int findMiddleIndex(int[] nums) {
    int midx=-1;
    for(int i=0;i<=nums.length-1;++i) {
      int ls=0;
      for(int j=0;j<i;++j)
        ls+=nums[j];
      int rs=0;
      for(int k=i+1;k<nums.length;++k)
        rs+=nums[k];
      if(ls==rs){
        midx=i;
        break;
      }
    }
    return midx;   
}
}