class Solution {
    public int sumSubarrayMins(int[] arr) {

        long sum = 0;
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Previous smaller element
        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Next smaller or equal element
        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        // Calculate contribution of every element
        for(int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            sum += (long) arr[i] * leftChoices * rightChoices;
            sum %= 1_000_000_007;
        }

        return (int) sum;
    }
}