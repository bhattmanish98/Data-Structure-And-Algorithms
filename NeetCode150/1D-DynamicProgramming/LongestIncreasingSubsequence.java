class LongestIncreasingSubsequence {
    // Time Complexity - O(n^2)
    public int lengthOfLIS(int[] nums) {
        int len = nums.length, result = 0;
        int[] memory = new int[len];
        for(int i=0;i<len;i++) {
            int maxValue = 0;
            for(int j=0;j<i;j++) { if(nums[i] > nums[j]) maxValue = Math.max(maxValue, memory[j]); }
            memory[i] = maxValue + 1;
            result = Math.max(result, maxValue+1);
        }
        return result;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
        System.out.println(longestIncreasingSubsequence.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}