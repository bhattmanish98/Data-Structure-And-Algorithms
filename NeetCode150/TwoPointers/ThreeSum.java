import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int len = nums.length;
        for(int i=0;i<len;i++) {
            int start = i+1;
            int end = len-1;
            while(start<end) {
                if(nums[i]+nums[start]+nums[end]==0) {
                    result.add(Arrays.asList(new Integer[]{nums[i], nums[start], nums[end]}));
                    start++;
                    end--;
                } else if(nums[i]+nums[start]+nums[end]<0) start++;
                else end--;
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}