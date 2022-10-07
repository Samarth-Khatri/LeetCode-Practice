class MyCalendarThree {
    Map<Integer, Integer> map = new TreeMap<>();
    int maxCnt = 0;

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            cnt += it.getValue();
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }
}
/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
