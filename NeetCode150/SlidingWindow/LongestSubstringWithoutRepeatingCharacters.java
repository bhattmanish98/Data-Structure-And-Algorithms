package NeetCode150.SlidingWindow;

import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {
    // Time complexity - O(n)
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int result = 0;
        int front = 0, rear = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while(front<len) {
            char c = s.charAt(front);
            if(!hashMap.containsKey(c)) {
                hashMap.put(c, front);
            } else {
                int temp = hashMap.get(c);
                for(int j=rear;j<=temp;j++) hashMap.remove(s.charAt(j));
                rear = temp+1;
                hashMap.put(c, front);
            }
            result = Math.max(result, front-rear+1);
            front++;
        }
        return result;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("  "));
    }
}
