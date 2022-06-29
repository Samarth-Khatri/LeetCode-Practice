class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(people, (a,b) -> {
            return (a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
        });
        for(int []x : people)
            res.add(x[1],x);
        return res.toArray(new int[people.length][2]);
    }
}