class Solution {
    public double average(int[] salary) {
        double min=Integer.MAX_VALUE, max=Integer.MIN_VALUE, sum=0;
        for(int amt : salary) {
            min = Math.min(min,amt);
            max = Math.max(max,amt);
            sum += amt;
        }
        return ((sum-max-min)/(salary.length-2));
    }
}