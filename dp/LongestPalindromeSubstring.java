package dp;

public class LongestPalindromeSubstring {
    boolean[][] palindrome;

    private boolean isPalindrome(String s, int j) {
        if (s.charAt(j) == s.charAt(j+1)) {
            return j <= 0 || palindrome[j - 1][j - 2];
        }
        return false;
    }

    public int longestPalindrome(String s) {
        int len = s.length();
        palindrome = new boolean[len][len];
        int count = 0;
        for (int g = 0;g<len;g++) {
            for (int i = 0,  j = g; j<len ;i++, j++) {
                if (g==0) {
                    palindrome[i][j] = true;
                    count++;
                }
                else {
                    if (g==1) {
                        if(s.charAt(i) == s.charAt(j)) {
                            palindrome[i][j] = true;
                            count++;
                        }
                    }
                    else {
                        if (s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]) {
                            palindrome[i][j] = true;
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "babad";
        LongestPalindromeSubstring longestPalindromeSubstring = new LongestPalindromeSubstring();
        System.out.println(longestPalindromeSubstring.longestPalindrome(s));
    }
}
