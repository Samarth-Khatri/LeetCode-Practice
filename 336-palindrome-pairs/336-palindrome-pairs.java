public class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> hm = new HashMap<>();

        // put all the words in HashMap for easy look-up
        for (int i = 0; i < words.length; i++) {
            hm.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String reverse = new StringBuilder(words[i]).reverse().toString();

            // check if there is reverse word present
            if (hm.containsKey(reverse) && hm.get(reverse) != i) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(hm.get(reverse));
                result.add(list);
            }

            // check if there is empty string
            // in that case if word is palindrome, empty string can be added
            // before and after the word.
            if (hm.containsKey("") && hm.get("") != i && new StringBuilder(words[i]).reverse().toString().equals(words[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(hm.get(""));
                result.add(list);
                list = new ArrayList<>();
                list.add(hm.get(""));
                list.add(i);
                result.add(list);
            }

            // check if some other word can be added as prefix
            int curReverse = 0;
            while (curReverse < reverse.length() - 1) {
                if (hm.containsKey(reverse.substring(0, curReverse + 1))) {
                    String rem = words[i].substring(0, words[i].length() - curReverse - 1);
                    if (new StringBuilder(rem).reverse().toString().equals(rem)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(hm.get(reverse.substring(0, curReverse + 1)));
                        list.add(i);
                        result.add(list);
                    }
                }
                curReverse++;
            }

            // check if some other word can be added as suffix
            int curForward = 0;
            while (curForward < words[i].length() - 1) {
                String rev = new StringBuilder(words[i].substring(0, curForward + 1)).reverse().toString();
                if (hm.containsKey(rev)) {
                    String rem = words[i].substring(curForward + 1);
                    if (new StringBuilder(rem).reverse().toString().equals(rem)) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(hm.get(rev));
                        result.add(list);
                    }
                }
                curForward++;
            }
        }
        return result;
    }
}
