// import java.util.HashMap;
// import java.util.Map;
import java.util.HashSet;

class LongestConsecutiveSubsequence {
    // public int longestConsecutive(int[] nums) {
    //     HashMap<Integer, Boolean> hashMap = new HashMap<>();
    //     for(int num: nums) {
    //         int previousNumber = num-1;
    //         if(hashMap.containsKey(previousNumber)) hashMap.put(previousNumber, true);
    //         if(hashMap.containsKey(num+1)) hashMap.put(num, true);
    //         else hashMap.put(num, false);
    //     }
    //     int result = Integer.MIN_VALUE;
    //     for(Map.Entry<Integer, Boolean> entry: hashMap.entrySet()) {
    //         int runnningCount = 1;
    //         int key = entry.getKey();
    //         while(hashMap.containsKey(key+1)) {
    //             runnningCount += 1;
    //             key += 1;
    //         }
    //         if(result<runnningCount) result = runnningCount;
    //     }
    //     return result;
    // }

    public int longestConsecutive(int[] nums) {
       if (nums.length == 0) return 0;
       HashSet<Integer> hs = new HashSet<>();
       for(int num:nums) hs.add(num);
       int longest =1;
       for(int num: nums ){
           if(!hs.contains(num-1)){
                int count =1;
                while(hs.contains(num + 1)){
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
           }
           if(longest > nums.length/2) break;
       }
       return longest;
    }
    public static void main(String[] args) {
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence();
        System.out.println(longestConsecutiveSubsequence.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}