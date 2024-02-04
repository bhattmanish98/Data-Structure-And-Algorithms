package NeetCode150.SlidingWindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class LongestRepeatingCharacterReplacement {
    private int mostFrequentCharacterLength(Map<Character, Integer> map) {
        return Collections.max(map.values());
    }

    // Using HashMap
    public int characterReplacement(String s, int k) {
        int len = s.length(), front = 0, rear = 0, result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        while(front<len) {
            int windowLength = front-rear+1;
            if(windowLength - mostFrequentCharacterLength(map) <= k) {
                result = Math.max(result, windowLength);
                front++;
                if(front < len) map.merge(s.charAt(front), 1, Integer::sum);
            } else {
                char c = s.charAt(rear);
                map.put(c, map.get(c)-1);
                rear++;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement longestRepeatingCharacterReplacement = new LongestRepeatingCharacterReplacement();
        System.out.println(longestRepeatingCharacterReplacement.characterReplacement("ABBAB", 2));
    }
    
    // Test for ABBAB
}
