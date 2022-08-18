class Solution {
    public int minSetSize(int[] arr) {
        if(arr.length == 1 || arr.length == 2) 
            return 1;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : arr) 
            map.put(val, map.getOrDefault(val, 0) + 1);
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int reqSize = arr.length/2, currSize = 0, cnt = 0;
        
        while(currSize < reqSize) {
            currSize += list.remove(0);
            cnt++;
        }

        return cnt;
    }
}