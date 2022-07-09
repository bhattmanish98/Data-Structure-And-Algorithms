package tree;

import java.util.HashMap;

public class MinimumOperation {
    public int minOperations(int[] nums, int x) {
        int len = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0,0);
        int prefixSum = 0;
        for (int i=0;i<len;i++) {
            prefixSum += nums[i];
            hm.put(prefixSum, i);
        }
        if (x > prefixSum) return -1;
        int subArraySum = prefixSum - x;
        prefixSum = 0;
        int longestSubArrayCount = 0;
        for (int i = 0;i<len;i++) {
            prefixSum += nums[i];
            Integer temp = prefixSum - subArraySum;
            if (hm.containsKey(temp)) {
                if (temp == 0)
                    longestSubArrayCount = Math.max(longestSubArrayCount, i - hm.get(temp) + 1);
                else
                    longestSubArrayCount = Math.max(longestSubArrayCount, i - hm.get(temp));
            }
        }
        return longestSubArrayCount == 0 ? ( subArraySum == 0 ? len:-1) : len - longestSubArrayCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,20,1,1,3};
        int x = 10;
        MinimumOperation minimumOperation = new MinimumOperation();
        System.out.println(minimumOperation.minOperations(nums, x));
    }
}
