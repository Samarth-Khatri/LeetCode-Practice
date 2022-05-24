class Solution {
    public int subtractProductAndSum(int n) {
        int sum=0;
        int product=1;
        int i = n;

        while(i>0){
            
            int lDigit = i % 10;
            sum += lDigit;
            product *= lDigit;
            i = i/10;
        }
        return (product - sum);
    }
}