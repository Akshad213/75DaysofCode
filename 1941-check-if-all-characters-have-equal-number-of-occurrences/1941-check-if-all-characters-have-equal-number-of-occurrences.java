class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
             char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int i=0;
        int prev=0;
        for(Character c: map.keySet()){
            if(i==0){
                prev = map.get(c);
                i++;
                continue;
            }

            int curr= map.get(c);
            if(curr != prev) return false;
        }

        return true;
    }
}