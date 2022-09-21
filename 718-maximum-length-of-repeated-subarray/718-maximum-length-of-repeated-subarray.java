class Solution {

    public static int maxLen(int start1, int start2, int[] nums1, int[] nums2) {
        int len = 0;
        int j = start2;
        for (int i = start1; i < nums1.length; i++) {
            if (nums1[i] == nums2[j]) 
                len++; 
            else return len;
            j++;
            if (j == nums2.length) 
                return len;
        }
        return len;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int val;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    val = maxLen(i, j, nums1, nums2);
                    if (val > max) 
                        max = val;
                    if (max >= (nums1.length - i)) 
                        return max; // to reduce time complexity
                }
            }
        }
        return max;
    }
}
