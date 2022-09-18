class Solution {

    public int calculate(String s) {
        int sign = 1;
        int res = 0;
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                res += val * sign;
                sign = 1;
            } else if (ch == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            } else if (ch == ')') {
                res *= st.pop();
                res += st.pop();
            } else if (ch == '-') {
                sign = sign * -1;
            }
        }
        return res;
    }
}
