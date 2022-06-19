class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList();
        Arrays.sort(products);
        for(int i=0;i<searchWord.length();++i) {
            List<String> ians = new ArrayList();
            String subs = searchWord.substring(0,i+1); 
            int idx = binarySearch(products, subs);
            for(int j=idx;j<products.length;++j) {
                if(products[j].startsWith(subs)) {
                    ians.add(products[j]);
                    if(ians.size()==3)
                      break;
                }
            }
            ans.add(ians);
        }
        return ans;
    }
    
    public int binarySearch(String[] products, String prefix) {
        int left=0, right=products.length-1,mid=0; 
        while(left<=right) {
            mid = left + (right-left)/2;
            if (products[mid].compareTo(prefix)>=0) 
                right =mid-1;
            else 
                left=mid+1;
        }
        return right+1; 
    }
}