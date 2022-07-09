package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int start = 0;
        int i = 0;
        int runningSum = 0;
        int maxSum = 0;
        while (i<nums.length) {
            int current = nums[i];
            if (!set.contains(current)) {
                set.add(current);
                runningSum += current;
                maxSum = Math.max(maxSum, runningSum);
                i++;
            } else {
                int delete = nums[start];
                set.remove(delete);
                runningSum = runningSum - delete;
                start ++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,2,4,5,6};
        MaximumErasureValue maximumErasureValue = new MaximumErasureValue();
        System.out.println(maximumErasureValue.maximumUniqueSubarray(nums));
    }
}
