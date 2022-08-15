class Solution {
    public int romanToInt(String s) {
        int res = 0;
        char prev = ' ';
        for(int i=0;i<s.length();++i) {
            char ch = s.charAt(i);
            res += getValue(ch, prev);
            prev = ch;
        }
        return res;
    }
    
    private int getValue(char c, char prev) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return prev == 'I' ? 3 : 5;
            case 'X':
                return prev == 'I' ? 8 : 10;
            case 'L':
                return prev == 'X' ? 30 : 50;
            case 'C':
                return prev == 'X' ? 80 : 100;
            case 'D':
                return prev == 'C' ? 300 : 500;
            case 'M':
                return prev == 'C' ? 800 : 1000;
        }
        return 0;
    }
}