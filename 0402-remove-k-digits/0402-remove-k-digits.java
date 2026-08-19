class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++) {

            char curr = num.charAt(i);

            while(!st.isEmpty() && k > 0 && st.peek() > curr) {
                st.pop();
                k--;
            }

            st.push(curr);
        }

        // If k is still remaining
        while(k > 0) {
            st.pop();
            k--;
        }

        String ans = "";

        while(!st.isEmpty()) {
            ans = st.pop() + ans;
        }

        // Remove leading zeroes
        int i = 0;

        while(i < ans.length() && ans.charAt(i) == '0') {
            i++;
        }

        ans = ans.substring(i);

        if(ans.length() == 0) {
            return "0";
        }

        return ans;
    }
}