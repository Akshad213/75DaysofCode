class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        long minSum = 0;
        long maxSum = 0;

        int left[] = new int[n];
        int right[] = new int[n];

        Stack<Integer> st = new Stack<>();

        // Find previous smaller for minimum
        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                left[i] = -1;
            }
            else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Find next smaller or equal for minimum
        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                right[i] = n;
            }
            else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        // Calculate sum of subarray minimums
        for(int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            minSum += (long) nums[i] * leftChoices * rightChoices;
        }


        // Reset arrays and stack
        st.clear();

        // Find previous greater for maximum
        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                left[i] = -1;
            }
            else {
                left[i] = st.peek();
            }

            st.push(i);
        }

        st.clear();

        // Find next greater or equal for maximum
        for(int i = n - 1; i >= 0; i--) {

            while(!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                right[i] = n;
            }
            else {
                right[i] = st.peek();
            }

            st.push(i);
        }

        // Calculate sum of subarray maximums
        for(int i = 0; i < n; i++) {

            long leftChoices = i - left[i];
            long rightChoices = right[i] - i;

            maxSum += (long) nums[i] * leftChoices * rightChoices;
        }

        return maxSum - minSum;
    }
}