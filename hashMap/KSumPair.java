package hashMap;

import java.util.HashMap;

public class KSumPair {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            int rem = k - num;
            if (map.containsKey(num) && map.get(num) >= 1) {
                map.put(num, map.get(num)-1);
                count += 1;
            } else {
                if (map.containsKey(rem)) map.put(rem, map.get(rem) + 1);
                else map.put(rem, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        int k = 3;
        KSumPair kSumPair = new KSumPair();
        System.out.print(kSumPair.maxOperations(nums, k));
    }
}
