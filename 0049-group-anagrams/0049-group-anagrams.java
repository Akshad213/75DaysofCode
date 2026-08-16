class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs) {

            int[] arr = new int[26];

            for(char c : s.toCharArray()) {
                arr[c - 'a']++;
            }

            String key = "";

            for(int i : arr) {
                key = key + "/" + i;
            }

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}