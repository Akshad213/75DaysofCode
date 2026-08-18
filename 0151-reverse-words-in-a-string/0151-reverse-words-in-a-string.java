class Solution {
    public String reverseWords(String s) {

        List<String> st = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            // Skip spaces
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }

            if (i >= s.length()) {
                break;
            }

            StringBuilder sb = new StringBuilder();

            // Take one complete word
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }

            st.add(sb.toString());
        }

        StringBuilder ans = new StringBuilder();

        // Traverse list backwards
        for (int j = st.size() - 1; j >= 0; j--) {

            ans.append(st.get(j));

            if (j != 0) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}