class Solution {
  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (int[] o1, int[] o2) -> o1[1] - o2[1]);
    int total_days = 0;
    PriorityQueue<Integer> q = new PriorityQueue<>(courses.length,(o1, o2) -> o2 - o1);
    for(int[] it: courses){ 
        q.add(it[0]);
        total_days += it[0];
        if (total_days > it[1]) 
            total_days -= q.poll();
    }
    return q.size();
  }
}