class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        int mul = 1;
        for(int i = columnTitle.length()-1; i>=0; i--) {
            result += (columnTitle.charAt(i) - 'A' + 1)*mul;
            mul *= 26;
        }
        return result;
    }
}