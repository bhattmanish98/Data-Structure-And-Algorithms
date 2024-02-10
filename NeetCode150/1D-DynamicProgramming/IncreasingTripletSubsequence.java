class IncreasingTripletSubsequence {
    // Time Complexity - O(n^2), Space Complexity - O(n)
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int[] count = new int[len];
        
        for(int i=0;i<len;i++) {
            int c = 0;
            for(int j=0;j<i;j++) { if (nums[i] > nums[j]) c = Math.max(c, count[j]); }
            count[i] = c + 1;
            if (c + 1 >= 3) return true;
        }
        return false;
    }

    // Time Complexity - O(n), Space Complexity - O(2*n)
    public boolean increasingTriplet2(int[] nums) {
        int len = nums.length;
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        leftMin[0] = nums[0];
        rightMax[len-1] = nums[len-1];
        for(int i=1;i<len;i++) leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        for(int i=len-2;i>0;i--) rightMax[i] = Math.max(rightMax[i+1], nums[i]);
        for(int i=0;i<len;i++) if(nums[i]>leftMin[i] && nums[i]<rightMax[i]) return true;
        return false;
    }

    // Time Complexity - O(n), Space Complexity - O(n)
    public boolean increasingTriplet3(int[] nums) {
        int len = nums.length;
        int[] leftMin = new int[len];
        leftMin[0] = nums[0];
        for(int i=1;i<len;i++) leftMin[i] = Math.min(leftMin[i-1], nums[i]);
        int rightMax = nums[len-1];
        for(int i=len-1;i>=0;i--) {
            if(nums[i] > leftMin[i] && nums[i] < rightMax) return true;
            rightMax = Math.max(rightMax, nums[i]);
        }
        return false;
    }

    // Time Complexity - O(n), Space Complexity - O(1)
    public boolean increasingTriplet4(int[] nums) {
        if(nums.length < 3) return false;
        int i = Integer.MAX_VALUE, j = Integer.MAX_VALUE;
        for(int k=0;k<nums.length;k++) {
            if (nums[k] <= i) i = nums[k];
            else if (nums[k] <= j) j = nums[k];
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence increasingTripletSubsequence = new IncreasingTripletSubsequence();
        System.out.println(increasingTripletSubsequence.increasingTriplet4(new int[]{2,1,5,0,4,6}));
    }
}