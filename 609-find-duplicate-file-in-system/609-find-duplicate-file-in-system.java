class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < paths.length; i++) {
            String[] str = paths[i].split(" ");
            String path = str[0];

            for (int j = 1; j < str.length; j++) {
                String file = str[j];
                String[] contents = file.split("\\(");

                StringBuilder sb = new StringBuilder("");
                sb.append(path);
                sb.append("/");
                sb.append(contents[0]);

                if (map.containsKey(contents[1])) {
                    ArrayList<String> list = map.get(contents[1]);
                    list.add(sb.toString());
                    map.put(contents[1], list);
                } 
                else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(sb.toString());
                    map.put(contents[1], list);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();

        for (ArrayList<String> list : map.values()) 
            if (list.size() > 1) 
                res.add(list);

        return res;
    }
}
